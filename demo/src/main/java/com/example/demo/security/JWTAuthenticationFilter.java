/// generat the proper full working no errors code for the JWTAuthenticationFilter class in the package com.example.demo.security that extends OncePerRequestFilter and implements the necessary methods to extract the JWT token from the request header, validate it and set the authentication in the security context if the token is valid. Make sure to use the appropriate annotations for the filter and also inject any necessary dependencies such as a JWT utility class to perform the token validation.
/// You can also add any necessary methods to handle the token extraction and validation logic, and make sure to return appropriate responses in case of invalid tokens or any other authentication errors.
/// Make sure to import any necessary classes and also handle any exceptions that might occur during the token validation process.
/// Make sure to test the filter to ensure that it is working correctly and properly securing the endpoints in the application.
/// Make sure to also add the filter to the security configuration to ensure that it is applied to the incoming requests.
/// Make sure to also handle the case where the token is missing from the request header and return an appropriate response in that case as well.
/// Make sure to also handle the case where the token is expired and return an appropriate response in that case as well.
/// Make sure to also handle the case where the token is invalid and return an appropriate response in that case as well.
/// Make sure to also handle the case where the token is valid but the user associated with the token is not found in the database and return an appropriate response in that case as well.
/// Make sure to also handle the case where the token is valid but the user associated with the token does not have the necessary roles or permissions to access the requested resource and return an appropriate response in that case as well.
/// Make sure to also handle the case where the token is valid but the user associated with the token is disabled or locked and return an appropriate response in that case as well.
/// Make sure to also handle the case where the token is valid but the user associated with the token has been deleted and return an appropriate response in that case as well.
/// 
/// Make sure to also handle the case where the token is valid but the user associated with the token has been deactivated and return an appropriate response in that case as well.

package com.example.demo.security;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = extractToken(request);
        if (token != null && jwtService.isTokenValid(token)) {
            String username = jwtService.getUsernameFromToken(token);
            if (username != null) {
                User user = userRepository.findByUsername(username);
                if (user != null) {
                    UserDetails userDetails = org.springframework.security.core.userdetails.User
                            .withUsername(user.getUsername())
                            .password(user.getPassword() == null ? "" : user.getPassword())
                            .authorities(Collections.emptyList())
                            .build();

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
