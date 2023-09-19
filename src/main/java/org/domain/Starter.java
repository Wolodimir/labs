package org.domain;

import org.domain.exception.DuplicateModelNameException;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) throws DuplicateModelNameException {
        carTests();
        //motorbikeTests();
    }

    public static void motorbikeTests() throws DuplicateModelNameException {
        Motorbike motorbike = new Motorbike("Ducatti");
        motorbike.addModel("F1", 10000.0);
        motorbike.addModel("F2", 20000.0);
        motorbike.addModel("F3", 30000.0);
        motorbike.addModel("F4", 40000.0);
        motorbike.removeModelByName("F2");
        motorbike.getAllModelNames();
        motorbike.getAllModelPrices();

        System.out.println(VehicleUtils.avgVehiclePrice(motorbike));

        System.out.println("hah");

        VehicleUtils.displayVehicleModelsRow(motorbike);
    }

    public static void carTests() {
        Car car = new Car("Skoda", 11);
        car.addModel("oktavia1", 10000.0);
        car.addModel("oktavia", 10000.0);
        car.addModel("oktavia2", 10000.0);

        System.out.println(Arrays.toString(car.getAllModelNames()));
        System.out.println(Arrays.toString(car.getAllModelPrices()));
        car.changePriceByModelName("oktavia", 99999.0);
        System.out.println(car.getPriceByModelName("oktavia"));


        car.removeModelByName("oktavia");
        car.removeModelByName("Model № 8");
        System.out.println(Arrays.toString(car.getAllModelNames()));
        System.out.println(Arrays.toString(car.getAllModelPrices()));
        car.changePriceByModelName("oktavia2", 888888.0);
        System.out.println(car.getPriceByModelName("oktavia2"));

        System.out.println(VehicleUtils.avgVehiclePrice(car));
        VehicleUtils.displayVehicleModelsRow(car);
    }
}