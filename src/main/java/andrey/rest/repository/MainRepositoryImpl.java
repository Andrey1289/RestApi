package andrey.rest.repository;

import andrey.rest.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainRepositoryImpl implements MainRepository{


    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Client getById(Long id) {
        return null;
    }

    @Override
    public List<ClientAccount> getAllClientAccountByIdClient(Long id) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionClientAccountById(Long id) {
        return null;
    }

    @Override
    public List<CashWarrant> getAllCashWarrantByClientAccountById(Long id) {
        return null;
    }

    @Override
    public CashWarrant createOrder(CashWarrant cashWarrant, OrderType orderType) {
        return null;
    }

    @Override
    public void createTransferBetweenOneClientAccount(Client client, Long from, Long to) {

    }

    @Override
    public void createTransferBetweenDifferentClientAccount(Client clientFrom, Client clientTo) {

    }
}
