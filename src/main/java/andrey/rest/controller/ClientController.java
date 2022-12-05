package andrey.rest.controller;

import andrey.rest.model.CashWarrant;
import andrey.rest.model.Client;
import andrey.rest.model.ClientAccount;
import andrey.rest.model.Transaction;
import andrey.rest.service.CashWarrantService;
import andrey.rest.service.ClientAccountService;
import andrey.rest.service.ClientService;
import andrey.rest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients/")
public class ClientController {

private final ClientService clientService;
private final ClientAccountService clientAccountService;
private final TransactionService transactionService;
private final CashWarrantService cashWarrantService;
   @Autowired
    public ClientController(ClientService clientService, ClientAccountService clientAccountService, TransactionService transactionService, CashWarrantService cashWarrantService) {
        this.clientService = clientService;
       this.clientAccountService = clientAccountService;
       this.transactionService = transactionService;
       this.cashWarrantService = cashWarrantService;
   }

      @GetMapping("/all")//Информация обо всех клиентах
public List<Client> findAll(){
          List<Client> clientList = clientService.getAll();
         System.out.println(clientList); // отладка
              return clientList;

      }
      @GetMapping("{id}")
      public Client findById(@PathVariable Long id){
       return  clientService.findClientById(id);
   }

   @GetMapping("accountClient/{id}")
    public List<ClientAccount> findAllAccountClient(@PathVariable Long id){

       return clientAccountService.findAllClientAccountById(id);
   }

   @GetMapping("transaction/{id}")
   public List<Transaction> getAllTransactionClientById(@PathVariable Long id){

       return transactionService.findAllTransactionByclientId(id);
   }

   @GetMapping("cashWarrant/{id}")
    public List<CashWarrant> getAllCashWarrantById(@PathVariable Long id){
       return cashWarrantService.findByidClientAccount(id);
   }

   @PostMapping("createClient")
    public Client createClient(@RequestBody Client client)throws NoSuchAlgorithmException {

       return clientService.createClient(client);
   }

}
