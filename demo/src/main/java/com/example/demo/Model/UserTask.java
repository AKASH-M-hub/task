//create the full code for the UserTask class in the package com.example.demo.Model with fields id, userId, taskId and also add the necessary annotations for the entity and the id field

package com.example.demo.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class UserTask {
    @Id
    private Long id;
    private Long userId;
    private Long taskId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
