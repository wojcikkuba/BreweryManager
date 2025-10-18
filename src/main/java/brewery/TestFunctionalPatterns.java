package brewery;

public class TestFunctionalPatterns {
    public static void main(String[] args) {
        System.out.println("=== TESTOWANIE WZORCÓW CZYNNOŚCIOWYCH ===\n");

        // Test Command
        System.out.println("1. Test Command Pattern:");
        BrewingUnit unit = new BrewingUnit();
        BrewingController controller = new BrewingController();

        Command startBrewing = new StartBrewingCommand(unit);
        Command fillBottles = new FillBottlesCommand(unit);
        Command clean = new CleanCommand(unit);

        controller.performAction(startBrewing);
        controller.performAction(fillBottles);
        controller.performAction(clean);

        System.out.println("\nCofanie ostatnich akcji:\n");
        controller.undoLastAction();
        controller.undoLastAction();
        controller.undoLastAction();
    }
}
