package com.project.Tasks.Repository;

import com.project.Tasks.Domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Boolean existsByUserIdAndTaskName(int userId, String task);

    Task findByUserIdAndTaskName(int userId, String task);

    List<Task> findByUserId(int userId);


}
