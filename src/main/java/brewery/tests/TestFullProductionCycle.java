package brewery.tests;

import brewery.domain.production.brewing.BrewingUnit;
import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.process.BottlingState;
import brewery.domain.production.process.BrewingProcess;

public class TestFullProductionCycle {
    public static void main(String[] args) {

        System.out.println("\nTest pełnego cyklu:");

        BrewingUnit unit = new BrewingUnit();
        FermentationContext fermentation = new FermentationContext(new FastFermentationStrategy());
        BrewingProcess process = new BrewingProcess();

        // WARZENIE
        unit.startBrewingProcess();
        process.nextStep();   // Preparation -> Brewing
        process.nextStep();   // Brewing -> Fermentation

        // FERMENTACJA
        fermentation.setFermentationTemperature(22);
        fermentation.startFermentation();
        process.nextStep();   // Fermentation -> Bottling

        // BUTELKOWANIE
        BottlingState bottling = new BottlingState();
        bottling.startBottlingProcess();

        System.out.println("Koniec cyklu");
    }
}
