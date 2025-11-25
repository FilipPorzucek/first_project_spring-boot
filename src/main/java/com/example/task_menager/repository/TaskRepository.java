package com.example.task_menager.repository;

import com.example.task_menager.model.Task;
import com.example.task_menager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByUser(User user);

}
