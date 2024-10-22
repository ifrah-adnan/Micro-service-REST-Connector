package ma.adnan.tp1microservice.web;

import ma.adnan.tp1microservice.entities.BankAccount;
import ma.adnan.tp1microservice.exception.AccountNotFoundException;
import ma.adnan.tp1microservice.repositories.BankAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RestController
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;

    public BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
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
    public BankAccount createAccount(@RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .type(bankAccount.getType())
                .balance(bankAccount.getBalance())
                .build();
        return bankAccountRepository.save(bankAccount1);
    }

    @PutMapping("/account/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found for this id" + id));


        bankAccount1.setBalance(bankAccount.getBalance());
        bankAccount1.setType(bankAccount.getType());
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
