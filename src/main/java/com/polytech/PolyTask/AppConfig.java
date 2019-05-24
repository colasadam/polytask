package com.polytech.PolyTask;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.PolyTask.application.*;
import com.polytech.PolyTask.data.JpaTaskRepository;
import com.polytech.PolyTask.data.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    TaskRepository taskRepository() {
        return new JpaTaskRepository();
    }

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://mysql-fatevald.alwaysdata.net:3306/fatevald_polytask");
        dataSource.setUser("fatevald");
        dataSource.setPassword("manureva0612");
        dataSource.setDatabaseName("fatevald_polytask");
        return dataSource;
    }
    @Bean
    FeedService feedService(){
        return new FeedServiceImp(taskRepository());
    }

    @Bean
    RegisterService registerService(){
        return new RegisterServiceImp(taskRepository());
    }

    @Bean
    PublicationService publicationService(){
        return new PublicationServiceImp(taskRepository());
    }



}
