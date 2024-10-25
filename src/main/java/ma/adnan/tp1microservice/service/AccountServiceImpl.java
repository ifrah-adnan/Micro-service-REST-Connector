package ma.adnan.tp1microservice.service;

import ma.adnan.tp1microservice.dto.BankAccountRequestDto;
import ma.adnan.tp1microservice.dto.BankAccountResponseDto;
import ma.adnan.tp1microservice.entities.BankAccount;
import ma.adnan.tp1microservice.mappers.AccountMappers;
import ma.adnan.tp1microservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
private  BankAccountRepository bankAccountRepository;
private AccountMappers accountMappers;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMappers accountMappers) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMappers = accountMappers;
    }

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount=accountMappers.fromBankAccountRequestDto(bankAccountDto);
BankAccount bankAccount1=bankAccountRepository.save(bankAccount);
BankAccountResponseDto bankAccountResponseDto=accountMappers.fromBankAccount(bankAccount1);

        return bankAccountResponseDto;
    }
}
