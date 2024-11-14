package ma.adnan.tp1microservice.repositories;

import ma.adnan.tp1microservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RepositoryRestResource
public interface CustomerRepositori extends JpaRepository<Customer,Long> {
}
