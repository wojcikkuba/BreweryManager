package brewery;

// Tydzień 2, Wzorzec Command 2 - Receiver
// Klasa BrewingUnit wykonuje konkretne akcje związane z procesem warzenia piwa.

public class BrewingUnit {
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
}

// Koniec, Tydzień 2, Wzorzec Command 2
