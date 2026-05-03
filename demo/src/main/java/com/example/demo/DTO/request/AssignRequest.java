/// create the CreateTaskRequest DTO for all fields in the package com.example.demo.DTO.request
/// fields: title, description, status, dueDate, assignedTo
/// status should be of type Status enum
/// assignedTo should be of type Long (user id)
/// also create the AssignRequest DTO for fields taskId and userId in the same package
/// taskId and userId should be of type Long
/// also create the UpdateRequest DTO for fields id, title, description, status, priority, assignedTo in the same package
/// id should be of type Long, title and description should be of type String, status should be of type Status enum, priority should be of type Priority enum and assignedTo should be of type Long (user id)
/// also create the LoginRequest DTO for fields email and password in the same package
/// email and password should be of type String
/// also create the Task class in the package com.example.demo.Model with fields id, title, description, status, priority, assignedTo and also add the necessary annotations for the entity and the id field
/// also create the User class in the package com.example.demo.Model with fields id, username,
/// password, email, role and also add the necessary annotations for the entity and the id field
/// also create the UserTask class in the package com.example.demo.Model with fields id, user

package com.example.demo.DTO.request;
public class AssignRequest {
    private Long taskId;
    private Long userId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}