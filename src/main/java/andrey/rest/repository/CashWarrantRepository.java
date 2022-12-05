package andrey.rest.repository;

import andrey.rest.model.CashWarrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashWarrantRepository extends JpaRepository<CashWarrant,Long> {
    public List<CashWarrant> findByidClientAccount(Long id);



}
