/// generate the full code for the mapper utils class in the package com.example.demo.util with methods to convert between User, Task, Comment and UserTask entities and their corresponding DTOs.
/// Make sure to add the necessary imports for the DTOs and also add comments to explain the purpose of each method.
/// You can use libraries like ModelMapper or MapStruct to simplify the mapping process, but you can also implement the mapping manually if you prefer.
/// Make sure to handle any necessary conversions between data types and also consider any edge cases that might arise during the mapping process.

package com.example.demo.util;

import com.example.demo.DTO.request.CreateTaskRequest;
import com.example.demo.DTO.request.LoginRequest;
import com.example.demo.Model.Comment;
import com.example.demo.Model.Task;
import com.example.demo.Model.User;
public class MapperUtils {
    public static User mapToUser(LoginRequest loginRequest) {
        User user = new User();
        user.setEmail(loginRequest.getEmail());
        user.setPassword(loginRequest.getPassword());
        return user;
    }

    public static Task mapToTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTitle(createTaskRequest.getTitle());
        task.setDescription(createTaskRequest.getDescription());
        task.setStatus(createTaskRequest.getStatus());
        task.setAssignedTo(createTaskRequest.getAssignedTo() == null ? null : String.valueOf(createTaskRequest.getAssignedTo()));
        return task;
    }

    public static Comment mapToComment(CommentRequestDTO commentRequestDTO) {
        Comment comment = new Comment();
        comment.setContent(commentRequestDTO.getContent());
        comment.setAuthor(commentRequestDTO.getAuthor());
        comment.setId(commentRequestDTO.getTaskId());
        return comment;
    }

    public static TaskResponseDTO mapToTaskResponseDTO(Task task) {
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setId(task.getId());
        taskResponseDTO.setTitle(task.getTitle());
        taskResponseDTO.setDescription(task.getDescription());
        taskResponseDTO.setStatus(task.getStatus());
        taskResponseDTO.setAssignedTo(task.getAssignedTo());
        return taskResponseDTO;
    }

    public static CommentResponseDTO mapToCommentResponseDTO(Comment comment) {
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
        commentResponseDTO.setId(comment.getId());
        commentResponseDTO.setContent(comment.getContent());
        commentResponseDTO.setAuthor(comment.getAuthor());
        commentResponseDTO.setId(comment.getId());
        return commentResponseDTO;
    }
}  