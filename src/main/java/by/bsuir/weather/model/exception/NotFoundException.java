package by.bsuir.weather.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Selected entity wasn't found")
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
