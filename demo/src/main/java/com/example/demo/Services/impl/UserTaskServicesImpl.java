/// generate the full code for the usertask services implementation class in the package com.example.demo.Services.impl with methods createUserTask, getUserTaskById, updateUserTask and deleteUserTask. Also add the necessary annotations for the service class and inject the UserTaskRepository to perform the database operations.
package com.example.demo.Services.impl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.UserTask;
import com.example.demo.Repository.UserTaskRepository;
@Service
public class UserTaskServicesImpl {
    @Autowired
    private UserTaskRepository userTaskRepository;

    public UserTask createUserTask(UserTask userTask) {
        return userTaskRepository.save(userTask);
    }

    public UserTask getUserTaskById(Long id) {
        Optional<UserTask> userTask = userTaskRepository.findById(id);
        if (userTask.isPresent()) {
            return userTask.get();
        } else {
            throw new RuntimeException("UserTask not found with id: " + id);
        }
    }

    public UserTask updateUserTask(Long id, UserTask userTask) {
        Optional<UserTask> existingUserTask = userTaskRepository.findById(id);
        if (existingUserTask.isPresent()) {
            UserTask updatedUserTask = existingUserTask.get();
            updatedUserTask.setUserId(userTask.getUserId());
            updatedUserTask.setTaskId(userTask.getTaskId());
            return userTaskRepository.save(updatedUserTask);
        } else {
            throw new RuntimeException("UserTask not found with id: " + id);
        }
    }

    public void deleteUserTask(Long id) {
        if (userTaskRepository.existsById(id)) {
            userTaskRepository.deleteById(id);
        } else {
            throw new RuntimeException("UserTask not found with id: " + id);
        }
    }
}