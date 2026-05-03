/// generate the full code fot he global exception handler class in the package com.example.demo.exception with the necessary annotations to handle exceptions globally in the application.
/// Make sure to handle the CustomException and also add a method to handle any other generic exceptions that might occur in the application.
/// You can also add a method to handle validation exceptions if you think it would be useful for the application.
///  Make sure to return appropriate responses for each type of exception and also include the necessary information in the response such as the error message and the status code.

package com.example.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}