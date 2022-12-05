package andrey.rest.controller;

import andrey.rest.model.ClientAccount;
import andrey.rest.service.ClientAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/createAccount")
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    public ClientAccountController(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @PostMapping("create")
    public ClientAccount createClientAccount(@RequestBody ClientAccount clientAccount){

        return clientAccountService.createClientAccount(clientAccount);
    }
}
