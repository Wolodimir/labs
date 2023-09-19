package org.domain.exception;

public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException(String nameModel) {
        super("Model named " + nameModel + " is already exists");
    }
}
