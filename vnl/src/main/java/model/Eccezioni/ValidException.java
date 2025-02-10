package model.Eccezioni;

import java.util.ArrayList;
import java.util.List;

public class ValidException extends RuntimeException {

    private final List<String> errorMessages;

    public ValidException(String message) {
        super(message);
        this.errorMessages=new ArrayList<String>();
        this.errorMessages.add(message);
    }






    public ValidException(List<String> errorMessages) {
        super(String.join("; ", errorMessages));  
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

}
    

