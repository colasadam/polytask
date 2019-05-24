package com.polytech.PolyTask.application;

public interface RegisterService {
    void insert_user(User user) throws UsernameAlreadyExistsException;
    void insert_authority(Authority authority);

}
