package ma.adnan.tp1microservice.repositories;

import ma.adnan.tp1microservice.entities.BankAccount;
import ma.adnan.tp1microservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
@RestResource(path = "/byType")
    List<BankAccount> findByType( @Param("t") AccountType type);
}
