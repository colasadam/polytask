package com.polytech.PolyTask.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "task")
public class Task {
    @Id
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name="username")
    private String username;

    @Column(name="done")
    private int done;

    @Column(name="date")
    private Date date;

    public Task(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Task(String content) {
        this.content = content;
    }

    public Task(String content, String username) {
        this.content = content;
        this.username = username;
    }

    public Task(){
    }

    public void setDone(int done) {
        this.done = done;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getDone() {
        return done;
    }

    public void setDone() {
        if(this.done==1) this.done=0;
        else this.done=1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
