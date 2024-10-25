package ma.adnan.tp1microservice.entities;

import ma.adnan.tp1microservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
public String getId();
public AccountType getType();

}
