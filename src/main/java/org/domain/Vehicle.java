package org.domain;

import org.domain.exception.DuplicateModelNameException;
import org.domain.exception.NoSuchModelNameException;

public interface Vehicle {

    void changeModelName(String currentName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;

    void removeModelByName(String name) throws NoSuchModelNameException;

    void addModel(String name, Double price) throws DuplicateModelNameException;

    void changePriceByModelName(String modelName, Double price) throws NoSuchModelNameException;

    Double getPriceByModelName(String modelName) throws NoSuchModelNameException;

    Double[] getAllModelPrices();

    String[] getAllModelNames();

    Integer getModelQuantity();

    String getBrand();

    void setBrand(String brand);

}
