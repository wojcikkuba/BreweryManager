package brewery.tests;

import brewery.domain.production.process.BrewingProcess;

public class TestStatePattern {
    public static void main(String[] args) {

        System.out.println("Test wzorca State:");
        BrewingProcess brewingProcess = new BrewingProcess();
            for (int i = 0; i < 5; i++) {
            brewingProcess.nextStep();
        }
    }
}
