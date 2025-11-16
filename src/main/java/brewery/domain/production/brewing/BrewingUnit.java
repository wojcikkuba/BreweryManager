package brewery.domain.production.brewing;

// Tydzień 2, Wzorzec Command 2 - Receiver
// Klasa BrewingUnit wykonuje konkretne akcje związane z procesem warzenia piwa.

import brewery.domain.production.brewing.operations.BrewingOperations;

public class BrewingUnit implements BrewingOperations {

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
        increaseTemperature(25);
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
