/// create the ful code for the user response class in the package com.example.demo.DTO.response with fields id, username, email and role
/// id should be of type Long, username, email and role should be of type String
/// also create the comment response class in the same package with fields id, content, author and taskId
/// id should be of type Long, content and author should be of type String and taskId
/// should be of type Long

package com.example.demo.DTO.response;
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}