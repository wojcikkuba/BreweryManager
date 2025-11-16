package brewery.domain.production.process;

import brewery.domain.production.bottling.operations.BottlingOperations;

public class BottlingState implements BrewingState, BottlingOperations {

    @Override
    public void handle(BrewingProcess context) {
        System.out.println("Butelkowanie gotowego piwa.");

        startBottlingProcess();

        context.setState(null); // koniec procesu
    }

    @Override
    public void startBottlingProcess() {
        performCleaning();
        sealBottle();
        labelBottle();
        System.out.println("Proces butelkowania zakończony.");
    }

    @Override
    public void performCleaning() {
        System.out.println("Czyszczenie sprzętu przed butelkowaniem...");
    }

    @Override
    public void sealBottle() {
        System.out.println("Zamykanie butelek...");
    }

    @Override
    public void labelBottle() {
        System.out.println("Naklejanie etykiet...");
    }
}