/// create the Authresonse DTO for all fields in the package com.example.demo.DTO.response
/// This class will be used to send the response for the authentication process. It will contain the following fields:
/// - token: The JWT token that will be used for authentication in the future request

package com.example.demo.DTO.response;
public class AuthResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
