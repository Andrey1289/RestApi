package andrey.rest.service;

import andrey.rest.model.*;
import andrey.rest.repository.CashWarrantRepository;
import andrey.rest.repository.ClientAccountRepository;
import andrey.rest.repository.ClientRepository;
import andrey.rest.repository.TransactionRepository;
import andrey.rest.utils.Hash;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashWarrantServiceImpl implements CashWarrantService {
    private final CashWarrantRepository cashWarrantRepository;
    private final ClientAccountRepository clientAccountRepository;
    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;

    public CashWarrantServiceImpl(CashWarrantRepository cashWarrantRepository, ClientAccountRepository clientAccountRepository, TransactionRepository transactionRepository, ClientRepository clientRepository) {
        this.cashWarrantRepository = cashWarrantRepository;
        this.clientAccountRepository = clientAccountRepository;
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<CashWarrant> findByidClientAccount(Long id) {
        ClientAccount clientAccount = clientAccountRepository.findByaccountNumber(id);
        return cashWarrantRepository.findByidClientAccount(clientAccount.getId());
    }

    @Override
    public CashWarrant createWarrant(CreateCashWarrantRequest createCashWarrantRequest) {
        // to do сделать проверку секретного слова
        ClientAccount clientAccount = clientAccountRepository.findByaccountNumber(createCashWarrantRequest.getAccountNumber());
        ClientAccount clientAccountForTransfer = clientAccountRepository.findByaccountNumber(createCashWarrantRequest.getNumberAccountForTransfer());
        long sum = 0;
        long replenishmentAmount = 0;

        if (createCashWarrantRequest.getOrderType() == OrderType.REPLENISHMENT) {
            sum = clientAccount.getSumOnAccountClient() + createCashWarrantRequest.getSumOrder();

        } else if (createCashWarrantRequest.getOrderType() == OrderType.WITHDRAWAL) {
            Client client = clientRepository.findById(clientAccount.getClientId()).get();
            String inputSecretHash = Hash.secretHash(createCashWarrantRequest.getSecretWord());
            if (client.getSecretWord().equals(inputSecretHash)) {
                if (clientAccount.getSumOnAccountClient() >= createCashWarrantRequest.getSumOrder()) {
                    sum = clientAccount.getSumOnAccountClient() - createCashWarrantRequest.getSumOrder();
                }
            }

        } else if (createCashWarrantRequest.getOrderType() == OrderType.TRANSFER) {
            Client client = clientRepository.findById(clientAccount.getClientId()).get();
            String inputSecretHash = Hash.secretHash(createCashWarrantRequest.getSecretWord());
            if (client.getSecretWord().equals(inputSecretHash)) {
                if (clientAccount.getSumOnAccountClient() >= createCashWarrantRequest.getSumOrder()) {
                    sum = clientAccount.getSumOnAccountClient() - createCashWarrantRequest.getSumOrder();
                    replenishmentAmount = clientAccountForTransfer.getSumOnAccountClient() + createCashWarrantRequest.getSumOrder();
                }
            }
        }

        CashWarrant cashWarrant = new CashWarrant();
        cashWarrant.setOrderType(createCashWarrantRequest.getOrderType());
        cashWarrant.setResultCashWarrant(sum > 0 ? ResultCashWarrant.SUCCESSFULLY : ResultCashWarrant.DOES_NOT_MATCH_SECRET_WORD);
        cashWarrant.setSumOrder(createCashWarrantRequest.getSumOrder());
        cashWarrant.setIdClientAccount(clientAccount.getId());
        cashWarrantRepository.save(cashWarrant);

        Transaction transaction = new Transaction();
        transaction.setIdCashWarrant(cashWarrant.getId());
        transaction.setIdClientAccount(clientAccount.getId());
        transaction.setResultTransaction(sum > 0 ? ResultTransaction.SUCCESSFULLY : ResultTransaction.DOES_NOT_MATCH_SECRET_WORD);
        transaction.setOrderType(cashWarrant.getOrderType());
        transaction.setSumTransaction(cashWarrant.getSumOrder());
        transactionRepository.save(transaction);
        if (sum > 0) {
            clientAccount.setSumOnAccountClient(sum);
            //clientAccountForTransfer.setSumOnAccountClient(replenishmentAmount);

            clientAccountRepository.save(clientAccount);
           // clientAccountRepository.save(clientAccountForTransfer);
        } else {
            //to do возвращать ошибку
        }

        return null;
    }

}
