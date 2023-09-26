package org.domain;

import org.domain.exception.DuplicateModelNameException;
import org.domain.exception.ModelPriceOutOfBoundsException;
import org.domain.exception.NoSuchModelNameException;

import java.util.Arrays;
import java.util.Objects;

public class Car implements Vehicle {

    private String brand;
    private Model[] models;

    public Car(String brand, int modelArrayLength) {
        this.models = new Model[modelArrayLength];
        for (int i = 0; i < modelArrayLength; i++) {
            Model model = new Model("Model № " + i, Math.random() * 1000000);
            models[i] = model;
        }
        this.brand = brand;
    }

    public Integer getModelsArraySize() {
        return models.length;
    }

    @Override
    public void changeModelName(String currentName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        try {
            getModelIndexByName(newName);
            throw new DuplicateModelNameException(newName);
        } catch (NoSuchModelNameException e) {
            this.models[getModelIndexByName(currentName)].setName(newName);
        }
    }

    @Override
    public void removeModelByName(String name) throws NoSuchModelNameException {
        int i = getModelIndexByName(name);
        int size = this.models.length;
        Objects.checkIndex(i, size);

        System.arraycopy(this.models, i + 1, this.models, i, size - i - 1);
        this.models = Arrays.copyOf(this.models, size -1);
    }

    @Override
    public void addModel(String name, Double price) {
        if (price > 1000000 || price < 10000) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        Model model = new Model(name, price);
        this.models = Arrays.copyOf(this.models, this.models.length + 1);
        this.models[this.models.length - 1] = model;
    }

    @Override
    public void changePriceByModelName(String modelName, Double price) throws NoSuchModelNameException {
        if (price > 1000000 || price < 10000) {
            throw new ModelPriceOutOfBoundsException(price);
        }
        this.models[getModelIndexByName(modelName)].setPrice(price);
    }

    @Override
    public Double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        return this.models[getModelIndexByName(modelName)].getPrice();
    }

    @Override
    public Double[] getAllModelPrices() {
        Double[] prices = new Double[this.models.length];
        for (int i = 0; i < this.models.length; i++) {
            prices[i] = this.models[i].getPrice();
        }
        return prices;
    }

    @Override
    public String[] getAllModelNames() {
        String[] names = new String[this.models.length];
        for (int i = 0; i < this.models.length; i++) {
            names[i] = this.models[i].getName();
        }
        return names;
    }

    @Override
    public Integer getModelQuantity() {
        return this.models.length;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    private Integer getModelIndexByName(String name) throws NoSuchModelNameException {
        for (int i = 0; i < this.models.length; i++) {
            if (name.equals(this.models[i].getName()))
                return i;
        }
        throw new NoSuchModelNameException(name);
    }

    private class Model {
        private String name;
        private Double price;

        public Model(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

}
