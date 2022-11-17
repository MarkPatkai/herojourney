package io.tearstar.herojourney.model.exceptions;

public class DataNotFoundException extends Exception {

    public DataNotFoundException() {
        super("Data not found!");
    }

    public DataNotFoundException(String type) {
        super(String.format("Data type (%s) not found in the database!", type));
    }

}
