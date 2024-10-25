package ma.adnan.tp1microservice.exception;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message){
        super(message);
    }
}
