package andrey.rest.controller;

import andrey.rest.model.CashWarrant;
import andrey.rest.model.CreateCashWarrantRequest;
import org.springframework.http.MediaType;
import andrey.rest.service.CashWarrantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class CashWarrantController {
   private final CashWarrantService cashWarrantService;

    public CashWarrantController(CashWarrantService cashWarrantService) {
        this.cashWarrantService = cashWarrantService;
    }

    @PostMapping("create")
    public CashWarrant createWarrant(@RequestBody CreateCashWarrantRequest createCashWarrantRequest){

        return cashWarrantService.createWarrant(createCashWarrantRequest);

    }

}
