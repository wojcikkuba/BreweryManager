package brewery.tests;

import brewery.domain.production.process.BottlingState;
import brewery.domain.production.process.BrewingProcess;

public class TestBottlingOperations {
    public static void main(String[] args) {

        System.out.println("\nTest butelkowania:");

        BottlingState state = new BottlingState();

        state.performCleaning();
        state.sealBottle();
        state.labelBottle();
        state.startBottlingProcess();

        System.out.println("\nTest butelkowania jako część procesu:");

        BrewingProcess process = new BrewingProcess();
        process.setState(new BottlingState());
        process.nextStep();
    }
}
