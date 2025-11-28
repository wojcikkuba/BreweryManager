package brewery.tests;

import brewery.domain.beer.Beer;
import brewery.domain.beer.Witbier;
import brewery.domain.inventory.IngredientInventory;
import brewery.domain.production.brewing.BrewingUnit;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.FermentationStrategy;
import brewery.domain.production.orchestration.BreweryProductionOrchestrator;
import brewery.domain.production.process.BrewingProcess;
import brewery.infrastructure.notification.EventNotificationService;

public class TestBreweryProductionOrchestrator {

    public static void main(String[] args) {

        System.out.println("\n=== TEST: BreweryProductionOrchestrator (poprawiona wersja) ===");

        // Przygotowanie zależności
        BrewingUnit unit = new BrewingUnit();
        FermentationStrategy strategy = new FastFermentationStrategy();
        FermentationContext fermentationCtx = new FermentationContext(strategy);
        IngredientInventory inventory = new IngredientInventory();
        EventNotificationService notificationService = new EventNotificationService();
        BrewingProcess brewingProcess = new BrewingProcess();

        // Utworzenie poprawionego orchestratora
        BreweryProductionOrchestrator orchestrator =
                new BreweryProductionOrchestrator(
                        unit,
                        fermentationCtx,
                        inventory,
                        notificationService,
                        brewingProcess
                );

        // Przykładowe piwo - KONKRETNA implementacja Beer
        Beer beer = new Witbier("Test Witbier");

        // Uruchomienie pełnego, poprawionego procesu
        orchestrator.runFullProduction(
                beer,
                strategy,                        // strategia fermentacji
                20,                              // temperatura fermentacji
                true,                            // wysyłanie powiadomień
                "Proces przebiegł prawidłowo!"   // dodatkowa wiadomość
        );

        System.out.println("=== KONIEC TESTU: BreweryProductionOrchestrator ===\n");
    }
}
