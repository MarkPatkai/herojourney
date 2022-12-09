package io.tearstar.herojourney.model.exceptions;

public class EventNotFoundException extends Exception {
    public EventNotFoundException(String message) {
        super("Event not found: " + message);
    }
}
