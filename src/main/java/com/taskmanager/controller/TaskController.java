package com.taskmanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

  private final TaskRepository taskRepository;

  @GetMapping
  public List<Task> getTasks(Authentication authentication) {
    String username = authentication.getName();
    return taskRepository.findByUsername(username);
  }

  @PostMapping
  public Task createTask(@RequestBody Task task, Authentication authentication) {
    String username = authentication.getName();
    task.setUsername(username);
    return taskRepository.save(task);
  }

  @PutMapping("/{id}")
  public Task updateTask(@PathVariable Long id,
                         @RequestBody Task updateTask,
                         Authentication authentication) {

    String username = authentication.getName();

    Task task = taskRepository.findById(id).orElseThrow();

    if (!task.getUsername().equals(username)) {
      throw new RuntimeException("Unauthorized");
    }

    task.setTitle(updateTask.getTitle());
    task.setDescription(updateTask.getDescription());
    task.setCompleted(updateTask.isCompleted());

    return taskRepository.save(task);
       }

       @DeleteMapping("/{id}")
       public void deleteTask(@PathVariable Long id, Authentication authentication) {
        String username = authentication.getName();
        Task task = taskRepository.findById(id).orElseThrow();

        if (!task.getUsername().equals(username)) {
          throw new RuntimeException("Unauthorized");
        }

        taskRepository.delete(task);
  }
}