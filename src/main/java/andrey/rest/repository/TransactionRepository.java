package andrey.rest.repository;

import andrey.rest.model.ClientAccount;
import andrey.rest.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    public List<Transaction> findByidClientAccount(Long id);
}
