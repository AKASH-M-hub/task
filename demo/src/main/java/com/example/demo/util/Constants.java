/// generate the full code for the constants class in the package com.example.demo.util with public static final String fields for JWT_SECRET, JWT_EXPIRATION and also add any other constants that you think are necessary for the application.
/// You can also add constants for the default user role and any other relevant information that might be useful across the application.
/// Make sure to use appropriate values for the constants and also add comments to explain their purpose.
/// Make sure to import any necessary classes for the constants if needed.

package com.example.demo.util;
public class Constants {
    public static final String JWT_SECRET = "your_jwt_secret_key";
    public static final long JWT_EXPIRATION = 86400000; // 24 hours in milliseconds
    public static final String DEFAULT_USER_ROLE = "USER";
}
