package org.domain;

import org.domain.exception.DuplicateModelNameException;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) throws DuplicateModelNameException {
        //carTests();
        motorbikeTests();
    }

    public static void motorbikeTests() throws DuplicateModelNameException {
        Motorbike motorbike = new Motorbike("Ducatti");
        motorbike.addModel("F1", 10000.0);
        motorbike.addModel("F2", 20000.0);
        motorbike.addModel("F3", 30000.0);
        motorbike.addModel("F4", 40000.0);
        System.out.println("hah");
    }

    public static void carTests() {
        Car car = new Car("Skoda", 11);
        car.addModel("oktavia1", 10000.0);
        car.addModel("oktavia", 10000.0);
        car.addModel("oktavia2", 10000.0);

        System.out.println(Arrays.toString(car.getAllModelsNames()));
        System.out.println(Arrays.toString(car.getAllModelsPrices()));
        car.changePriceByModelName("oktavia", 99999.0);
        System.out.println(car.getPriceByModelName("oktavia"));


        car.removeModelByName("oktavia");
        car.removeModelByName("Model № 8");
        System.out.println(Arrays.toString(car.getAllModelsNames()));
        System.out.println(Arrays.toString(car.getAllModelsPrices()));
        car.changePriceByModelName("oktavia2", 8888888888.0);
        System.out.println(car.getPriceByModelName("oktavia2"));
    }
}