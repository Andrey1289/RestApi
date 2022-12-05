package andrey.rest.service;

import andrey.rest.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    public List<Transaction> findAllTransactionByclientId(Long id);
}
