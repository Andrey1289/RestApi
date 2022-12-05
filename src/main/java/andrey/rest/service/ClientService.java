package andrey.rest.service;

import andrey.rest.model.Client;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface ClientService {
   public List<Client> getAll();
   public Client findClientById(Long id);
   public Client createClient(Client client) throws NoSuchAlgorithmException;

}
