package org.example;

public class Motobike implements Vehicle{

    private String brand;
    private Integer size = 0;
    private Long lastModified;
    private Model head = new Model();
    {
        head.prev = head;
        head.next = head;
    }

    @Override
    public void removeModelByName(String name) {

    }

    @Override
    public void addModel(String name, Double price) {

    }

    @Override
    public void changePriceByModelName(String modelName, Double price) {

    }

    @Override
    public Double getPriceByModelName(String modelName) {
        return null;
    }

    @Override
    public Double[] getAllModelsPrices() {
        return new Double[0];
    }

    @Override
    public String[] getAllModelsNames() {
        return new String[0];
    }


    private class Model {
        String nameModel = null;
        Double price = Double.NaN;
        Model prev = null;
        Model next = null;
    }
}
