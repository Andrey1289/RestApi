package andrey.rest.service;

import andrey.rest.model.ClientAccount;
import andrey.rest.model.Transaction;
import andrey.rest.repository.ClientAccountRepository;
import andrey.rest.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final ClientAccountRepository clientAccountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ClientAccountRepository clientAccountRepository) {
        this.transactionRepository = transactionRepository;
        this.clientAccountRepository = clientAccountRepository;
    }

    @Override
    public List<Transaction> findAllTransactionByclientId(Long id) {
        ClientAccount clientAccount = clientAccountRepository.findByaccountNumber(id);

        return transactionRepository.findByidClientAccount(clientAccount.getId());
    }
}
