package org.domain;

import org.domain.exception.DuplicateModelNameException;
import org.domain.exception.ModelPriceOutOfBoundsException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Motorbike implements Vehicle{

    private String brand;
    private Integer size = 0;
    private Long lastModified;
    private Model head = new Model();
    {
        this.head.prev = head;
        this.head.next = head;
    }

    public Motorbike(String brand) {
        this.brand = brand;
        this.lastModified = new Date().getTime();
    }

    @Override
    public void removeModelByName(String name) {

    }

    @Override
    public void addModel(String name, Double price) {
        if (getModelByName(name) != null) {
            //throw new DuplicateModelNameException(name);
        } else if (price > 1000000 || price < 10000) {
            //throw new ModelPriceOutOfBoundsException(price);
        }
        if (this.head.next == null) {
            System.out.println("List is empty");
        } else {
            Model lastModel = this.head.prev;
            Model newModel = new Model();
            newModel.modelName = name;
            newModel.price = price;
            lastModel.next = newModel;
            newModel.next = head;
            newModel.prev = lastModel;
            this.head.prev = newModel;
            this.size++;
        }
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

    private Model getModelByName(String modelName) {
        if (Objects.equals(this.head.modelName, modelName)) {
            return this.head;
        }
        Model model = head;
        while (model.next != head) {
            if (Objects.equals(model.next.modelName, modelName)) {
                return model.next;
            }
            model = model.next;
        }
        return null;
    }

    private class Model {
        String modelName = null;
        Double price = Double.NaN;
        Model prev = null;
        Model next = null;
    }
}
