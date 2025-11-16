package brewery;

import brewery.application.BrewingController;
import brewery.domain.production.BrewingUnit;
import brewery.domain.production.ProductionUnit;
import brewery.domain.recipe.RecipeCaretaker;
import brewery.domain.recipe.RecipeOriginator;
import brewery.patterns.command.CleanCommand;
import brewery.patterns.command.Command;
import brewery.patterns.command.FillBottlesCommand;
import brewery.patterns.command.StartBrewingCommand;
import brewery.patterns.mediator.BreweryMediator;
import brewery.patterns.mediator.InventoryMediator;

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

        System.out.println("\n4. Test wzorca Mediator:");
        BreweryMediator mediator = new BreweryMediator();
        ProductionUnit production = new ProductionUnit(mediator);
        InventoryMediator inventory = new InventoryMediator(mediator);
        mediator.setProduction(production);
        mediator.setInventory(inventory);

        production.finishBatch();
        inventory.detectLowStock();

        System.out.println("\n5. Test wzorca Memento:");
        RecipeOriginator recipe = new RecipeOriginator();
        RecipeCaretaker caretaker = new RecipeCaretaker();

        recipe.setMalt("Pilsner Malt");
        recipe.setHops("Saaz");
        recipe.setFermentationDays(10);
        System.out.println("Obecna receptura: " + recipe);

        caretaker.saveState(recipe);

        recipe.setMalt("Munich Malt");
        recipe.setHops("Fuggle");
        recipe.setFermentationDays(14);
        System.out.println("Zmodyfikowana receptura: " + recipe);

        System.out.println("Przywracanie poprzedniego stanu...");
        caretaker.undo(recipe);
        System.out.println("Receptura po przywróceniu: " + recipe);
    }
}
