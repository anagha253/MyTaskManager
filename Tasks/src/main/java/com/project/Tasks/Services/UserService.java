package com.project.Tasks.Services;

import com.project.Tasks.Domain.User;
import com.project.Tasks.Domain.view.UserRequest;
import com.project.Tasks.Repository.UserRepository;
import com.project.Tasks.Util.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    private Boolean checkUserExist(final String name){
        //call dao layer and check if this name in DB
        return userRepository.existsByName(name);
    }
    private Boolean checkUserPassword(UserRequest userRequest){
        User user = userRepository.findByName(userRequest.name);
        return userRequest.password.equals(user.password);
    }

    public void createUser(final UserRequest userData){
        log.info("user with name: {} is getting created", userData.name);
        //check if user exists
        if(!checkUserExist(userData.name)){
            final User user= new User();
            user.userId = UUID.randomUUID().toString();
            user.name=userData.name;
            user.password = userData.password;
            userRepository.save(user);
        }
        else{
            throw new TaskNotFoundException("User-already exists");
        }
    }

    public Boolean loginUser(final UserRequest userRequest){
        log.info("user with name: {} is trying to login",userRequest.name);
        if (checkUserExist(userRequest.name)){
            return checkUserPassword(userRequest);
        }
        return false;
    }

}
