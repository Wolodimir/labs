package org.domain.exception;

public class ModelPriceOutOfBoundsException extends RuntimeException {

    public ModelPriceOutOfBoundsException(double price) {
        super("Price [" + price + "] is out of bound");
    }
}
