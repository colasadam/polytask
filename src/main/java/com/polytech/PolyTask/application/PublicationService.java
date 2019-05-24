package com.polytech.PolyTask.application;

public interface PublicationService {

    void share(Task task);

    void delete_task(int id);

    void modif(int id, String s);

    void done(int id);
}
