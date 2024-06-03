package ru.gb.Patterns_HW12.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.Patterns_HW12.model.Task;
import ru.gb.Patterns_HW12.model.TaskStatus;


public interface TaskRepository  extends JpaRepository<Task, Long>{
    List<Task> findByStatus(TaskStatus status);
}