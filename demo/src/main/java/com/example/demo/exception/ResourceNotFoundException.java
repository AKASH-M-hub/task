/// genrate the full code for the ResourceNotFoundException class in the package com.example.demo.exception with a constructor that takes a message and also add any other necessary methods or fields that you think are necessary for the application.
/// Make sure to extend the appropriate exception class and also add any necessary annotations if needed.
/// You can also add a field for the HTTP status code and a method to get the status code if you think it would be useful for the application.
/// Make sure to return appropriate responses for this exception in the GlobalExceptionHandler class.
/// You can also add a method to handle this exception in the GlobalExceptionHandler class if you think it would be useful for the application.

package com.example.demo.exception;
public class ResourceNotFoundException extends RuntimeException {
    private int statusCode;

    public ResourceNotFoundException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
