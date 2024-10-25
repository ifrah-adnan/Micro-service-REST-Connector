package ma.adnan.tp1microservice.web;

import ma.adnan.tp1microservice.dto.BankAccountRequestDto;
import ma.adnan.tp1microservice.dto.BankAccountResponseDto;
import ma.adnan.tp1microservice.entities.BankAccount;
import ma.adnan.tp1microservice.exception.AccountNotFoundException;
import ma.adnan.tp1microservice.repositories.BankAccountRepository;
import ma.adnan.tp1microservice.service.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RestController
@RequestMapping("/api")
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private AccountServiceImpl accountService;

    public BankAccountController(BankAccountRepository bankAccountRepository, AccountServiceImpl accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public List<BankAccount> fetchAccount() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public BankAccount accountById(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account not found for this " + id)));
    }

    @PostMapping("/account")
    public BankAccountResponseDto createAccount(@RequestBody BankAccountRequestDto bankAccount) {

        return accountService.addAccount(bankAccount);
    }

    @PutMapping("/account/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found for this id" + id));


        if(bankAccount.getBalance()!=null) bankAccount1.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null)bankAccount1.setType(bankAccount.getType());
        return bankAccountRepository.save(bankAccount1);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        if (!bankAccountRepository.existsById(id)) {
            throw new AccountNotFoundException("Bank account with ID " + id + " not found");
        }

        bankAccountRepository.deleteById(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
