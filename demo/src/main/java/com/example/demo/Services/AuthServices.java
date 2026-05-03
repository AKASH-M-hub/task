/// generate the full coode for the auth services class in the package com.example.demo.Services with methods for register, login and logout. The register method should take a User object and save it to the database, the login method should take a username and password and return a JWT token if the credentials are valid, and the logout method should invalidate the JWT token.
/// You can use the following code as a starting point for the AuthServices class:

package com.example.demo.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.DTO.response.AuthResponse;
@Service
public class AuthServices { 
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public AuthResponse login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Generate JWT token and return it in the response
            String token = generateToken(user);
            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(token);
            return authResponse;
        }
        throw new RuntimeException("Invalid username or password");
    }

    public void logout(String token) {
        // Invalidate the JWT token
        invalidateToken(token);
    }

    private String generateToken(User user) {
        // Implement JWT token generation logic here
        return "dummy-jwt-token";
    }

    private void invalidateToken(String token) {
        // Implement JWT token invalidation logic here
    }
}