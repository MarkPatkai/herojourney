package io.tearstar.herojourney.model.exceptions;

public class AuthException extends Exception {

    public AuthException(String user) {
        super("User by name " + user + " not found!");
    }
}
