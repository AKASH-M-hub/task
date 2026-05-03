/// create the full code for the UpdateRequest class in the package com.example.demo.DTO.request with fields id, title, description, status, dueDate, assignedTo. status should be of type Status enum and assignedTo should be of type Long (user id)
/// also create the CreateTaskRequest DTO for all fields in the package com.example.demo.DTO.request
/// fields: title, description, status, dueDate, assignedTo

package com.example.demo.DTO.request;
import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;
public class UpdateRequest {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Long assignedTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }
}