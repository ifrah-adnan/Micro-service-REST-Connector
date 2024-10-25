package ma.adnan.tp1microservice.service;

import ma.adnan.tp1microservice.dto.BankAccountRequestDto;
import ma.adnan.tp1microservice.dto.BankAccountResponseDto;
import ma.adnan.tp1microservice.entities.BankAccount;
import org.springframework.stereotype.Service;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/

public interface AccountService {
BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
}
