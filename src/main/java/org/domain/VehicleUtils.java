package org.domain;

public class VehicleUtils {

    public static Double avgVehiclePrice(Vehicle vehicle) {
        Double[] prices = vehicle.getAllModelPrices();
        Integer quantity = vehicle.getModelQuantity();
        Double sum = 0.0;
        for (int i = 0; i < quantity; i++) {
            sum += prices[i];
        }
        return sum/quantity;
    }

    public static void displayVehicleModelsRow(Vehicle vehicle) {
        System.out.println("Brand: " + vehicle.getBrand());

        String[] modelNames = vehicle.getAllModelNames();
        Double[] modelPrices = vehicle.getAllModelPrices();
        Integer quantity = vehicle.getModelQuantity();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Model: " + modelNames[i] + ", It's price: " + modelPrices[i]);
        }
    }

}
