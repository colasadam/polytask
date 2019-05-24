package com.polytech.PolyTask.application;

import com.polytech.PolyTask.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class PublicationServiceImp implements PublicationService {

    @Autowired
    private TaskRepository taskRepository;

    public PublicationServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override

    public void share(Task task) {
        System.out.println("test Puvlication Service");
        taskRepository.save(task);
    }

    @Override
    public void delete_task(int id) {
        taskRepository.delete(id);
    }

    @Override
    public void modif(int id, String s) {
        taskRepository.modif(id,s);
    }

    @Override
    public void done(int id) {
        taskRepository.done(id);
    }
}
