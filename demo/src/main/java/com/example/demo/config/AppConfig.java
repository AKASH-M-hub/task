/// generate the full code for the appconfig class in the package com.example.demo.config with necessary annotations for configuration and also add a bean for password encoder using BCryptPasswordEncoder.
/// Make sure to import the necessary classes for the configuration and the password encoder.
/// You can use the following code as a starting point for the AppConfig class:
/// Also make sure to add the necessary dependencies for Spring Security and BCrypt in your build file.

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}