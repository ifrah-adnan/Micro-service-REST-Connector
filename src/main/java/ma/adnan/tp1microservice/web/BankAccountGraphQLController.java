package ma.adnan.tp1microservice.web;

import ma.adnan.tp1microservice.dto.BankAccountRequestDto;
import ma.adnan.tp1microservice.dto.BankAccountResponseDto;
import ma.adnan.tp1microservice.entities.BankAccount;
import ma.adnan.tp1microservice.entities.Customer;
import ma.adnan.tp1microservice.exception.AccountNotFoundException;
import ma.adnan.tp1microservice.mappers.AccountMappers;
import ma.adnan.tp1microservice.repositories.BankAccountRepository;
import ma.adnan.tp1microservice.repositories.CustomerRepositori;
import ma.adnan.tp1microservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Dell Latitude 5420
 *  IFRAH ADNAN
 **/
@Controller
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private CustomerRepositori customerRepositori;
private AccountMappers accountMappers;
    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, AccountService accountService, CustomerRepositori customerRepositori, AccountMappers accountMappers) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.customerRepositori = customerRepositori;
        this.accountMappers = accountMappers;
    }
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("not found"));
    }
    @MutationMapping
    public BankAccount addAccount(@Argument BankAccountRequestDto BankAccount){
        BankAccountResponseDto bankAccountResponseDto= accountService.addAccount(BankAccount);
return accountMappers.fromBankAccountResponseDto(bankAccountResponseDto);
    }
    @MutationMapping
    public BankAccount updateAccount(@Argument String id ,@Argument BankAccount BankAccount){
        BankAccount bankAccount1=bankAccountRepository.findById(id).orElseThrow();

        if(BankAccount.getBalance()!=null) bankAccount1.setBalance(BankAccount.getBalance());
        if(BankAccount.getType()!=null)bankAccount1.setType(BankAccount.getType());
        return bankAccountRepository.save(bankAccount1);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
    return true;
    }
    @QueryMapping
    public List<Customer> getCustomers(){
        return customerRepositori.findAll();

    }
}


