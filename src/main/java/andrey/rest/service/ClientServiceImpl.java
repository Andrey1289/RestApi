package andrey.rest.service;

import andrey.rest.model.Client;
import andrey.rest.repository.ClientRepository;
import andrey.rest.utils.Hash;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override   // поправить метод
    public Client findClientById(Long id) {
        if (clientRepository.existsById(id)) {

            return clientRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Client createClient(Client client)  {
        String encodedhash = Hash.secretHash(client.getSecretWord());
            client.setSecretWord(encodedhash);

        return clientRepository.save(client);
    }



}
