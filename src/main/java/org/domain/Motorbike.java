package org.domain;

import org.domain.exception.DuplicateModelNameException;
import org.domain.exception.ModelPriceOutOfBoundsException;
import org.domain.exception.NoSuchModelNameException;

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
    public void removeModelByName(String name) throws NoSuchModelNameException {
        Model model = getModelByName(name);
        if (model == null) {
            throw new NoSuchModelNameException(name);
        }
        Model prev = model.prev;
        Model next = model.next;

        prev.next = model.next;
        next.prev = model.prev;
        this.size--;
        this.lastModified = new Date().getTime();
    }

    @Override
    public void addModel(String name, Double price) throws DuplicateModelNameException {
        if (getModelByName(name) != null) {
            throw new DuplicateModelNameException(name);
        } else if (price > 1000000 || price < 10000) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        if (this.head.next == null) {
            System.out.println("List is empty");
        } else {
            Model lastModel = this.head.prev;
            Model newModel = new Model();
            newModel.name = name;
            newModel.price = price;
            lastModel.next = newModel;
            newModel.next = this.head;
            newModel.prev = lastModel;
            this.head.prev = newModel;
            this.size++;
            this.lastModified = new Date().getTime();
        }
    }

    @Override
    public void changePriceByModelName(String modelName, Double price) throws NoSuchModelNameException {
        if (price > 1000000 || price < 10000) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        Model model = getModelByName(modelName);
        if (model == null) {
            throw new NoSuchModelNameException(modelName);
        }
        model.price = price;
        this.lastModified = new Date().getTime();
    }

    @Override
    public Double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        Model model = getModelByName(modelName);
        if (model == null) {
            throw new NoSuchModelNameException(modelName);
        }
        return model.price;
    }

    @Override
    public Double[] getAllModelPrices() {
        Double[] prices = new Double[this.size];
        Model model = this.head.next;
        for (int i = 0; i < this.size; i++) {
            prices[i] = model.price;
            model = model.next;
        }
        return prices;
    }

    @Override
    public String[] getAllModelNames() {
        String[] names = new String[this.size];
        Model model = this.head.next;
        for (int i = 0; i < this.size; i++) {
            names[i] = model.name;
            model = model.next;
        }
        return names;
    }

    @Override
    public Integer getModelQuantity() {
        return this.size;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private Model getModelByName(String modelName) {
        if (Objects.equals(this.head.name, modelName)) {
            return this.head;
        }
        Model model = this.head;
        while (model.next != this.head) {
            if (Objects.equals(model.next.name, modelName)) {
                return model.next;
            }
            model = model.next;
        }
        return null;
    }

    private class Model {
        String name = null;
        Double price = Double.NaN;
        Model prev = null;
        Model next = null;
    }
}
