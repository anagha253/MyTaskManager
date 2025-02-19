package com.project.Tasks.Controller;

import com.project.Tasks.Domain.Task;
import com.project.Tasks.Domain.view.TaskRequest;
import com.project.Tasks.Services.TaskService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/tasks")
@Validated
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping("/fetch")
    public List<Task> fetchTasks(@RequestBody final TaskRequest taskRequest){
        return taskService.getTask(taskRequest.userName);
    }

    @PostMapping("/create")
    public void createTasks(@NotNull @RequestBody final TaskRequest taskRequest){
        taskService.createTask(taskRequest);
    }

    @PutMapping("/update")
    public void updateTasks(@NotNull @RequestBody final TaskRequest taskRequest){
        taskService.updateTask(taskRequest);
    }

    @PutMapping("/complete")
    public void finishTask(@NotNull @RequestBody final TaskRequest taskRequest){
        taskService.finishTask(taskRequest);

    }

    @DeleteMapping("/delete")
    public void removeTask(@NotNull @RequestBody final TaskRequest taskRequest){
        taskService.removeTask(taskRequest);
    }

}
