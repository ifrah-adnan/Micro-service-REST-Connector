package ma.adnan.tp1microservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDto {
    private String currency;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
