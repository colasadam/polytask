package com.polytech.PolyTask.application;

import com.polytech.PolyTask.data.TaskRepository;


public class RegisterServiceImp implements RegisterService {
    private TaskRepository taskRepository;

    public RegisterServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override

    public void insert_user(User user) throws UsernameAlreadyExistsException{
        taskRepository.save_user(user);
    }

    public void insert_authority(Authority authority){taskRepository.save_authority(authority);}


}
