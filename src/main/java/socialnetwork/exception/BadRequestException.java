package socialnetwork.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseApiException{
    public BadRequestException(HttpStatus status, String message) {
        super(status, message);
    }
}
