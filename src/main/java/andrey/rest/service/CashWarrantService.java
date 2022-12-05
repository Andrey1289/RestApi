package andrey.rest.service;

import andrey.rest.model.CashWarrant;
import andrey.rest.model.CreateCashWarrantRequest;
import andrey.rest.model.OrderType;

import java.util.List;

public interface CashWarrantService {
    public List<CashWarrant> findByidClientAccount(Long id);
    public CashWarrant createWarrant(CreateCashWarrantRequest createCashWarrantRequest);
}
