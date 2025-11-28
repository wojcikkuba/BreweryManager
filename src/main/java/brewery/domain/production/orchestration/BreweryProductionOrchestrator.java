package brewery.domain.production.orchestration;

import brewery.domain.beer.Beer;
import brewery.domain.inventory.IngredientInventory;
import brewery.domain.production.brewing.BrewingUnit;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.fermentation.FermentationStrategy;
import brewery.domain.production.process.BottlingState;
import brewery.domain.production.process.BrewingProcess;
import brewery.infrastructure.notification.EventNotificationService;

/**
 * Klasa odpowiedzialna za orkiestrację procesu produkcji piwa:
 * - warzenie
 * - fermentacja
 * - butelkowanie
 * - powiadomienia
 */
public class BreweryProductionOrchestrator {

    private final BrewingUnit brewingUnit;
    private final FermentationContext fermentationContext;
    private final IngredientInventory inventory;
    private final EventNotificationService notificationService;
    private final BrewingProcess brewingProcess;

    public BreweryProductionOrchestrator(BrewingUnit brewingUnit,
                                         FermentationContext fermentationContext,
                                         IngredientInventory inventory,
                                         EventNotificationService notificationService,
                                         BrewingProcess brewingProcess) {
        this.brewingUnit = brewingUnit;
        this.fermentationContext = fermentationContext;
        this.inventory = inventory;
        this.notificationService = notificationService;
        this.brewingProcess = brewingProcess;
    }

    /**
     * Główna metoda uruchamiająca cały proces produkcji.
     */
    public void runFullProduction(Beer beer,
                                  FermentationStrategy fermentationStrategy,
                                  int fermentationTemperature,
                                  boolean sendNotifications,
                                  String additionalMessage) {

        showBeerInfo(beer);
        showInventory();
        startBrewing();
        advanceBrewingProcessToFermentation();
        runFermentation(fermentationStrategy, fermentationTemperature);
        runBottling();
        sendCompletionNotifications(beer, sendNotifications, additionalMessage);
        cleanUp();
    }

    // ===== PRYWATNE, MAŁE METODY =====

    private void showBeerInfo(Beer beer) {
        System.out.println("=== Rozpoczynam produkcję piwa: " + beer.getName() + " ===");
        System.out.println("Styl: " + beer.getStyle());
        System.out.println("Zawartość alkoholu: " + beer.getAlcoholContent());
    }

    private void showInventory() {
        inventory.showInventory();
    }

    private void startBrewing() {
        brewingUnit.startBrewingProcess();
    }

    private void advanceBrewingProcessToFermentation() {
        brewingProcess.nextStep(); // Preparation -> Brewing
        brewingProcess.nextStep(); // Brewing -> Fermentation
    }

    private void runFermentation(FermentationStrategy strategy, int temperature) {
        fermentationContext.setStrategy(strategy);
        fermentationContext.setFermentationTemperature(temperature);
        fermentationContext.startFermentation();
        fermentationContext.applyFermentationStrategy();
    }

    private void runBottling() {
        BottlingState bottlingState = new BottlingState();
        bottlingState.startBottlingProcess();
    }

    private void sendCompletionNotifications(Beer beer,
                                             boolean sendNotifications,
                                             String additionalMessage) {
        if (!sendNotifications || notificationService == null) {
            return;
        }

        notificationService.notifyEvent("Zakończono proces produkcji piwa: " + beer.getName());

        if (additionalMessage != null && !additionalMessage.isBlank()) {
            notificationService.notifyEvent(additionalMessage);
        }
    }

    private void cleanUp() {
        brewingUnit.cleanEquipment();
        brewingUnit.stopBrewing();
        System.out.println("=== Proces produkcji zakończony ===");
    }
}
