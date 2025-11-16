package brewery.tests;

import brewery.domain.production.brewing.BrewingUnit;

public class TestBrewingOperations {

    public static void main(String[] args) {

        System.out.println("\nTest ważenia piwa:");

        BrewingUnit unit = new BrewingUnit();

        unit.prepareIngredients();
        unit.prepareBrewingEquipment();
        unit.mixRawIngredients();
        unit.increaseTemperature(10);
        unit.decreaseTemperature(5);
        unit.startBrewingProcess();
    }
}