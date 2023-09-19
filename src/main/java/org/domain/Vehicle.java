package org.domain;

import org.domain.exception.DuplicateModelNameException;

public interface Vehicle {

    void removeModelByName(String name);

    void addModel(String name, Double price) throws DuplicateModelNameException;

    void changePriceByModelName(String modelName, Double price);

    Double getPriceByModelName(String modelName);

    Double[] getAllModelsPrices();

    String[] getAllModelsNames();

}
