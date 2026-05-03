/// generate the full code for the task response class in the package com.example.demo.DTO.response with fields id, title, description, status, priority, dueDate, assignedTo and also add the necessary getters and setters for each field. status should be of type Status enum and assignedTo should be of type Long (user id)
/// also create the AddRequest DTO for fields title, description, status, dueDate, assignedTo in the same package
/// title and description should be of type String, status should be of type Status enum, due

package com.example.demo.DTO.response;
import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private String dueDate;
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