package com.polytech.PolyTask.data;

import com.polytech.PolyTask.application.Authority;
import com.polytech.PolyTask.application.Task;
import com.polytech.PolyTask.application.User;
import com.polytech.PolyTask.application.UsernameAlreadyExistsException;

import java.util.List;

public interface TaskRepository {
    List findAll();

    void save_user(User user) throws UsernameAlreadyExistsException;

    void save_authority(Authority authority);

    List save(Task task);

    void delete(int id);

    void modif(int id, String s);

    void done(int id);

}
