package org.example;

public interface Vehicle {

    void removeModelByName(String name);
    void addModel(String name, Double price);
    void changePriceByModelName(String modelName, Double price);
    Double getPriceByModelName(String modelName);
    Double[] getAllModelsPrices();
    String[] getAllModelsNames();

}
