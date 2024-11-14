package ma.adnan.tp1microservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BankAccount> bankAccountList;
}
