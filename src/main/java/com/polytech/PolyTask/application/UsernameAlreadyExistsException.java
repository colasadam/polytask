package com.polytech.PolyTask.application;

public class UsernameAlreadyExistsException extends  Exception {
    public UsernameAlreadyExistsException(String username) {
        super("Le nom d'utilisateur " +  username + " est déjà utilisé !");
    }
}


