package org.domain;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) {
        //carTests();
        motorbikeTests();
    }

    public static void motorbikeTests() {
        Motorbike motorbike = new Motorbike("Ducatti");
        motorbike.addModel("F1", 1000.0);
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