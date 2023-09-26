package org.domain;

import org.domain.exception.DuplicateModelNameException;
import org.domain.exception.NoSuchModelNameException;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {
        //carTests();
        //motorbikeTests();
        //newMotorbikeTests();
        newCarTests();
    }

    public static void newMotorbikeTests() throws DuplicateModelNameException, NoSuchModelNameException {
        Motorbike motorbike = new Motorbike("Yamaha", 10);
        VehicleUtils.displayVehicleModelsRow(motorbike);

        motorbike.removeModelByName("Model № 5");
        motorbike.changeModelName("Model № 8", "UUUH TI KAKOOOI");
        VehicleUtils.displayVehicleModelsRow(motorbike);

        //Exceptions
        //motorbike.changeModelName("THERE-IS-NO-MODEL", "UUUH TI KAKOOOI");
        //motorbike.changePriceByModelName("UUUH TI KAKOOOI", 0.0);
        //motorbike.changeModelName("Model № 8", "Model № 4");

    }

    public static void newCarTests() throws DuplicateModelNameException, NoSuchModelNameException {
        Car motorbike = new Car("Skoda", 10);
        VehicleUtils.displayVehicleModelsRow(motorbike);

        motorbike.removeModelByName("Model № 5");
        motorbike.changeModelName("Model № 8", "Model № 4");
        VehicleUtils.displayVehicleModelsRow(motorbike);

        //Exceptions
        //motorbike.changeModelName("THERE-IS-NO-MODEL", "UUUH TI KAKOOOI");
        //motorbike.changePriceByModelName("UUUH TI KAKOOOI", 0.0);
        //motorbike.changeModelName("Model № 8", "Model № 4");

    }

    public static void motorbikeTests() throws DuplicateModelNameException, NoSuchModelNameException {
        Motorbike motorbike = new Motorbike("Ducatti", 10);
        motorbike.addModel("F1", 10000.0);
        motorbike.addModel("F2", 20000.0);
        motorbike.addModel("F3", 30000.0);
        motorbike.addModel("F4", 40000.0);
        motorbike.removeModelByName("F2");
        motorbike.getAllModelNames();
        motorbike.getAllModelPrices();

        System.out.println(VehicleUtils.avgVehiclePrice(motorbike));

        System.out.println("----------");

        VehicleUtils.displayVehicleModelsRow(motorbike);
    }

    public static void carTests() throws NoSuchModelNameException {
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