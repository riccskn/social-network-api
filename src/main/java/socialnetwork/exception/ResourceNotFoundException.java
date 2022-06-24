package socialnetwork.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseApiException{
    public ResourceNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
