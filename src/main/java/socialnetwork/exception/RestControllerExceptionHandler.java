package socialnetwork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import socialnetwork.payload.ApiResponse;

@ControllerAdvice
public class RestControllerExceptionHandler {

   public ResponseEntity<ApiResponse> resolveException(BaseApiException exception) {

     ApiResponse response = new ApiResponse();

     response.setMessage(exception.getMessage());
     response.setSuccess(false);

     return new ResponseEntity<>(response,exception.getStatus());
   }

   @ExceptionHandler
   @ResponseBody
    public ResponseEntity<ApiResponse> resolveException(ResourceNotFoundException exception) {

       ApiResponse response = new ApiResponse();

       response.setMessage(exception.getMessage());
       response.setSuccess(false);

       return new ResponseEntity<>(response,exception.getStatus());

   }

   @ExceptionHandler
   @ResponseBody
     public ResponseEntity<ApiResponse> resolveException(BadRequestException exception) {
       ApiResponse response = new ApiResponse();

       response.setMessage(exception.getMessage());
       response.setSuccess(false);

       return new ResponseEntity<>(response,exception.getStatus());
   }

}
