package org.example;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) {
        Car car = new Car("Skoda", 11);
        car.addModel("Skoda oktavia1", 10000.0);
        car.addModel("Skoda oktavia", 10000.0);
        car.addModel("Skoda oktavia2", 10000.0);
        car.addModel("Skoda oktavia3", 10000.0);
        car.addModel("Skoda oktavia4", 10000.0);
        car.addModel("Skoda oktavia5", 10000.0);
        car.addModel("Skoda oktavia6", 10000.0);
        car.addModel("Skoda oktavia7", 10000.0);
        car.addModel("Skoda oktavia8", 10000.0);
        car.addModel("Skoda oktavia9", 10000.0);

        System.out.println(Arrays.toString(car.getAllModelsNames()));
        System.out.println(Arrays.toString(car.getAllModelsPrices()));
        car.changePriceByModelName("Skoda oktavia", 99999.0);
        System.out.println(car.getPriceByModelName("Skoda oktavia"));


        car.removeModelByName("Skoda oktavia5");
        car.removeModelByName("Model № 8");
        System.out.println(Arrays.toString(car.getAllModelsNames()));
        System.out.println(Arrays.toString(car.getAllModelsPrices()));
        car.changePriceByModelName("Skoda oktavia4", 8888888888.0);
        System.out.println(car.getPriceByModelName("Skoda oktavia4"));
    }
}