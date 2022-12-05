package andrey.rest.service;

import andrey.rest.model.ClientAccount;

import java.util.List;

public interface ClientAccountService {
    public List<ClientAccount> findAllClientAccountById(Long id);
    public ClientAccount createClientAccount(ClientAccount clientAccount);
}
