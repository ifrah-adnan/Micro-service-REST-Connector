package ma.adnan.tp1microservice.mappers;

import ma.adnan.tp1microservice.dto.BankAccountRequestDto;
import ma.adnan.tp1microservice.dto.BankAccountResponseDto;
import ma.adnan.tp1microservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Component
public class AccountMappers {

    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDto bankAccountResponseDto=BankAccountResponseDto.builder().id(bankAccount.getId()).currency(bankAccount.getCurrency()).balance(bankAccount.getBalance()).type(bankAccount.getType()).createdAt(bankAccount.getCreatedAt()).build();
return  bankAccountResponseDto;
    }
    public BankAccount fromBankAccountRequestDto(BankAccountRequestDto bankAccountRequestDto){
      BankAccount bankAccount=BankAccount.builder().id(UUID.randomUUID().toString()).createdAt(new Date()).balance(bankAccountRequestDto.getBalance()).currency(bankAccountRequestDto.getCurrency()).type(bankAccountRequestDto.getType()).build();
        return  bankAccount;
    }
}
