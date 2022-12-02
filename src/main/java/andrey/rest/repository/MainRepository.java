package andrey.rest.repository;

import andrey.rest.model.*;


import java.util.List;

public interface MainRepository {

    public List<Client> getAll();

    public Client getById(Long id);

    public List<ClientAccount> getAllClientAccountByIdClient(Long id);

    public List<Transaction> getAllTransactionClientAccountById(Long id);

    public List<CashWarrant> getAllCashWarrantByClientAccountById(Long id);

    public CashWarrant createOrder(CashWarrant cashWarrant, OrderType orderType);

    public void createTransferBetweenOneClientAccount(Client client, Long from, Long to);

    public void createTransferBetweenDifferentClientAccount(Client clientFrom , Client clientTo );


}
