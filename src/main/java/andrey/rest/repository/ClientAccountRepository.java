package andrey.rest.repository;

import andrey.rest.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount,Long> {

    public List<ClientAccount> findByclientId(Long id);

    public ClientAccount findByaccountNumber(Long accountNumber);

}
