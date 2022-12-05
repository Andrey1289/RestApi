package andrey.rest.service;

import andrey.rest.model.ClientAccount;
import andrey.rest.repository.ClientAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientAccountServiceImpl implements ClientAccountService{
   private final ClientAccountRepository clientAccountRepository;

    public ClientAccountServiceImpl(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }

    @Override
    public List<ClientAccount> findAllClientAccountById(Long id) {
        return clientAccountRepository.findByclientId(id);
    }

    @Override
    public ClientAccount createClientAccount(ClientAccount clientAccount) {
        return clientAccountRepository.save(clientAccount);
    }
}
