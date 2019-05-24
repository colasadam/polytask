package com.polytech.PolyTask.application;


import com.polytech.PolyTask.data.TaskRepository;

import java.util.List;

public class FeedServiceImp implements FeedService {

    private TaskRepository taskRepository;

    public FeedServiceImp (TaskRepository Sr) {
        taskRepository =Sr;
    }

    public List fetchAll() {
        return taskRepository.findAll();
    }
}
