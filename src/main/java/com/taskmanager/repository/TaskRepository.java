package com.taskmanager.repository;

import java.util.List;
import com.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUsername(String username);
}
