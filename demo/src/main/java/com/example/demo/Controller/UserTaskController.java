package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserTask;
import com.example.demo.Repository.UserTaskRepository;

@RestController
@RequestMapping("/usertasks")
public class UserTaskController {

    private final UserTaskRepository userTaskRepository;

    public UserTaskController(UserTaskRepository userTaskRepository) {
        this.userTaskRepository = userTaskRepository;
    }

    @PostMapping
    public ResponseEntity<UserTask> createUserTask(@RequestBody UserTask userTask) {
        UserTask createdUserTask = userTaskRepository.save(userTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTask> getUserTaskById(@PathVariable Long id) {
        Optional<UserTask> userTask = userTaskRepository.findById(id);
        return userTask.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTask> updateUserTask(@PathVariable Long id, @RequestBody UserTask userTask) {
        return userTaskRepository.findById(id)
                .map(existingUserTask -> {
                    existingUserTask.setUserId(userTask.getUserId());
                    existingUserTask.setTaskId(userTask.getTaskId());
                    return ResponseEntity.ok(userTaskRepository.save(existingUserTask));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserTask(@PathVariable Long id) {
        if (!userTaskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userTaskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
