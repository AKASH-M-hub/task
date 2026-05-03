/// create the CreateTaskRequest DTO for all fields in the package com.example.demo.DTO.request
/// fields: title, description, status, dueDate, assignedTo
/// status should be of type Status enum
/// assignedTo should be of type Long (user id) 

package com.example.demo.DTO.request;
import com.example.demo.enums.Status;
public class CreateTaskRequest {
    private String title;
    private String description;
    private Status status;
    private String dueDate;
    private Long assignedTo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }
}