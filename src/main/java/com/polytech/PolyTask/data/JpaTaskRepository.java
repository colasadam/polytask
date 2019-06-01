package com.polytech.PolyTask.data;

import com.polytech.PolyTask.application.Authority;
import com.polytech.PolyTask.application.Task;
import com.polytech.PolyTask.application.User;
import com.polytech.PolyTask.application.UsernameAlreadyExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@Transactional
public class JpaTaskRepository implements TaskRepository{
    @PersistenceContext
    EntityManager entityManager;

    public JpaTaskRepository(){

    }
    @Override
    public List<Task> findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String Name = authentication.getName();
        Query query = entityManager.createQuery("SELECT t FROM Task t where t.username ="+"'"+Name+"'");
        return query.getResultList();
    }

    @Override
    public List<Task> save(Task task) {
        entityManager.persist(task);
        return findAll();
    }

    @Override
    public void delete(int id) {
        Task task = entityManager.find(Task.class,id);
        entityManager.remove(task);

    }

    @Override
    public void modif(int id, String s) {
        Task task = entityManager.find(Task.class,id);
        task.setContent(s);
    }

    @Override
    public void done(int id) {
        Task task = entityManager.find(Task.class,id);
        task.setDone(!task.getDone());
    }

    @Transactional
    @Override
    public void save_user(User user) throws UsernameAlreadyExistsException {
        User isInDatabase = entityManager.find(User.class, user.getUsername());

        if(isInDatabase == null){
            entityManager.persist(user);
        } else {
            throw new UsernameAlreadyExistsException(user.getUsername());
        }
    }


    @Override
    public void save_authority(Authority authority) {
        entityManager.persist(authority);
    }
}
