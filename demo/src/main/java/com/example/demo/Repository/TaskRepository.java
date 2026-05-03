//create the full code for the TaskRepository class in the package com.example.demo.Repository with the necessary annotations,,incl all the atttributes nd the fields for the TaskRepository class

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Task;
import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitle(String title);

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);
}