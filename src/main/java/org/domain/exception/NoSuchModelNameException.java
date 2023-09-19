package org.domain.exception;

public class NoSuchModelNameException extends Exception {

    public NoSuchModelNameException(String nameModel) {
        super("Model named " + nameModel + " is not exists");
    }
}
