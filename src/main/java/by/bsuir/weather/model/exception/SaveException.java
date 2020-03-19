package by.bsuir.weather.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Can't save your entity")
public class SaveException extends RuntimeException{
    public SaveException(String message) {
        super(message);
    }
}
