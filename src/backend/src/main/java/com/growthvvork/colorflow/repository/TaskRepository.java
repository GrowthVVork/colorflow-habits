package com.growthvvork.colorflow.repository;

import com.growthvvork.colorflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom query methods here if needed
}