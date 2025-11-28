package brewery.domain.production.brewing;

// Tydzień 2, Wzorzec Command 2 - Receiver
// Klasa BrewingUnit wykonuje konkretne akcje związane z procesem warzenia piwa.

import brewery.domain.production.brewing.operations.BrewingOperations;

public class BrewingUnit implements BrewingOperations {
    private static final int DEFAULT_TEMPERATURE_INCREASE = 25;
    private static final int MIXING_TEMPERATURE_INCREASE = 10;
    private static final int COOLING_STEP = 5;
    public void startBrewing() {
        System.out.println("Brewing unit started the brewing process...");
    }

    public void stopBrewing() {
        System.out.println("Brewing unit stopped the brewing process.");
    }

    public void cleanEquipment() {
        System.out.println("Cleaning brewing equipment...");
    }

    public void fillBottles() {
        System.out.println("Filling bottles with freshly brewed beer...");
    }

    // ========= IMPLEMENTACJA INTERFEJSÓW ==========

    @Override
    public void startBrewingProcess() {
        System.out.println("Uruchamiam pełen proces warzenia...");
        startBrewing();
        prepareIngredients();
        prepareBrewingEquipment();
        mixRawIngredients();
        increaseTemperature(DEFAULT_TEMPERATURE_INCREASE);
        System.out.println("Warzenie zostało rozpoczęte (ISP).");
    }

    @Override
    public void prepareIngredients() {
        System.out.println("Przygotowanie składników (ISP).");
    }

    @Override
    public void prepareBrewingEquipment() {
        System.out.println("Przygotowanie sprzętu (ISP).");
    }

    @Override
    public void mixRawIngredients() {
        System.out.println("Mieszanie składników (ISP).");
        increaseTemperature(MIXING_TEMPERATURE_INCREASE);

    }

    @Override
    public void increaseTemperature(int amount) {
        System.out.println("Zwiększam temperaturę o " + amount + "°C (ISP).");
    }

    @Override
    public void decreaseTemperature(int amount) {
        System.out.println("Zmniejszam temperaturę o " + amount + "°C (ISP).");
    }
}

// Koniec, Tydzień 2, Wzorzec Command 2
