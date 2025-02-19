package com.project.Tasks.Services;

import com.project.Tasks.Constants.Status;
import com.project.Tasks.Domain.Task;
import com.project.Tasks.Domain.User;
import com.project.Tasks.Domain.view.TaskRequest;
import com.project.Tasks.Repository.TaskRepository;
import com.project.Tasks.Repository.UserRepository;
import com.project.Tasks.Util.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class TaskService {

    private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(final TaskRequest taskRequest){
        User user = userRepository.findByName(taskRequest.userName);
        log.info("user: {}",user);
        final int id = user.id;
        if (!taskRepository.existsByUserIdAndTaskName(id,taskRequest.taskName)){
            Task task = new Task();
            task.userId = id;
            task.taskName = taskRequest.taskName;
            task.status = Status.todo;
            taskRepository.save(task);
        }

    }

    public void updateTask(final TaskRequest taskRequest){
        User user = userRepository.findByName(taskRequest.userName);
        final int id = user.id;
        Task task = taskRepository.findByUserIdAndTaskName(id,taskRequest.oldTask);
        if (task != null){
            task.taskName = taskRequest.taskName;
            task.status = Status.todo;
            taskRepository.save(task);
        }
        else{
            throw new TaskNotFoundException("Something wrong with name/task-name");
        }

    }

    public List<Task> getTask(final String userName){
        log.info("user name: {}", userName);
        User user = userRepository.findByName(userName);
        final int id = user.id;
        return taskRepository.findByUserId(id);
    }

    public void finishTask(final TaskRequest taskRequest){
        User user = userRepository.findByName(taskRequest.userName);
        final int id = user.id;
        Task task = taskRepository.findByUserIdAndTaskName(id,taskRequest.taskName);
        if (task != null){
            task.taskName = taskRequest.taskName;
            task.status = Status.completed;
            taskRepository.save(task);
        }
        else{
            throw new TaskNotFoundException("Something wrong with name/task-name");
        }
    }

    public void removeTask(final TaskRequest taskRequest){
        User user = userRepository.findByName(taskRequest.userName);
        final int id = user.id;
        Task task = taskRepository.findByUserIdAndTaskName(id,taskRequest.taskName);
        if (task!=null){
            taskRepository.delete(task);
        }
        else{
            throw new TaskNotFoundException("Task not found");
        }
    }
}

