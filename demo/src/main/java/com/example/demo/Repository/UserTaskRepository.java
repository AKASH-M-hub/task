
package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.UserTask;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

    List<UserTask> findByUserId(Long userId);

    List<UserTask> findByTaskId(Long taskId);

    List<UserTask> findByUserIdAndTaskId(Long userId, Long taskId);
}