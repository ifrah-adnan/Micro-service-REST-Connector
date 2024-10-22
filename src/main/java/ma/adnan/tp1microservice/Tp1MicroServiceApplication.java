package ma.adnan.tp1microservice;

import ma.adnan.tp1microservice.entities.BankAccount;
import ma.adnan.tp1microservice.enums.AccountType;
import ma.adnan.tp1microservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Tp1MicroServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(Tp1MicroServiceApplication.class, args);


	}

	@Bean
	public CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount= BankAccount.builder().currency("MAD").id(UUID.randomUUID().toString()).balance(Math.random()*1000).createdAt(new Date()).type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT).build();
				bankAccountRepository.save(bankAccount);

			}


        };
    }
}
