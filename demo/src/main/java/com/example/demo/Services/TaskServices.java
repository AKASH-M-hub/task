/// generate the task services class for the task controller
/// this class will contain the business logic for the task controller
/// it will contain the following methods:
/// - createTask: takes a Task object as a parameter and returns a Task object.
/// - getTaskById: takes a Long id as a parameter and returns a Task object
/// - updateTask: takes a Long id and a Task object as parameters and returns a Task
/// object.
/// - deleteTask: takes a Long id as a parameter and returns void.
/// Make sure to add the necessary annotations for the service class and also inject the TaskRepository to perform the database operations.
package com.example.demo.Services;
import com.example.demo.Model.Task; 
import com.example.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskServices {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            existingTask.setDueDate(task.getDeadline());
            existingTask.setAssignedTo(task.getAssignedTo());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}