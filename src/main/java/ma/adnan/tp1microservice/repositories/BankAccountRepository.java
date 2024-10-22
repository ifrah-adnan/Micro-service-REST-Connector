package ma.adnan.tp1microservice.repositories;

import ma.adnan.tp1microservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
