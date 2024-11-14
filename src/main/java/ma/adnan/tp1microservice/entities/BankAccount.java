package ma.adnan.tp1microservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.adnan.tp1microservice.enums.AccountType;

import java.util.Date;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private String currency;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

}
