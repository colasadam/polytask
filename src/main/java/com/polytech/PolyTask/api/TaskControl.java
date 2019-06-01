package com.polytech.PolyTask.api;

import com.polytech.PolyTask.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskControl {


    @Autowired
    FeedService feedService;

    @Autowired
    RegisterService registerService;

    @Autowired
    PublicationService publicationService;

    @GetMapping("/feed")
    public List<Task> feed() {
        return feedService.fetchAll();
    }

    @PostMapping("/test_users")
    public void user(@RequestBody User user) throws UsernameAlreadyExistsException {
            user.setEnabled(1);
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            registerService.insert_user(user);
            Authority authority =new Authority(user.getUsername(),"admin");
            registerService.insert_authority(authority);
    }

    @PostMapping("/task")
    public List<Task> task(@RequestBody Task task){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String Name = authentication.getName();
        task.setUsername(Name);
        publicationService.share(task);
        return feedService.fetchAll();
    }

    @PostMapping("/delete")
    public List<Task> delete_story(@RequestBody int id) {
        publicationService.delete_task(id);
        return feedService.fetchAll();
    }

    @PostMapping("/modif/{id_task}")
    public List<Task> modif(@PathVariable("id_task") int id, @RequestBody String s) {
        publicationService.modif(id,s);
        return feedService.fetchAll();

    }

    @PostMapping("/done")
    public List<Task> done(@RequestBody int id){
        publicationService.done(id);
        return feedService.fetchAll();
    }
}
