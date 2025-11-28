package brewery.tests;

import brewery.BadBreweryOrchestrator;
import brewery.domain.beer.Beer;
import brewery.domain.beer.Lager;
import brewery.domain.inventory.IngredientInventory;
import brewery.domain.production.brewing.BrewingUnit;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.process.BrewingProcess;
import brewery.infrastructure.notification.EventNotificationService;

public class TestBadBreweryOrchestrator {

    public static void main(String[] args) {

        System.out.println("\n=== TEST: BadBreweryOrchestrator (niepoprawna wersja) ===");

        // Przygotowanie zależności
        BrewingUnit unit = new BrewingUnit();
        FermentationContext fermentationCtx = new FermentationContext(new FastFermentationStrategy());
        IngredientInventory inventory = new IngredientInventory();
        EventNotificationService notificationService = new EventNotificationService();
        BrewingProcess brewingProcess = new BrewingProcess();

        // Utworzenie „brzydkiego” orchestratora
        BadBreweryOrchestrator bad = new BadBreweryOrchestrator(
                unit,
                fermentationCtx,
                inventory,
                notificationService,
                brewingProcess
        );

        // Przykładowe piwo - KONKRETNA implementacja, nie Beer
        Beer beer = new Lager("Test Lager");

        // Wywołanie bardzo długiej metody z wieloma parametrami
        bad.doAllStuffInBrewery(
                beer,
                true,                 // szybka fermentacja
                22,                   // temperatura fermentacji
                true,                 // powiadomienia włączone
                "Proces zakończony!", // dodatkowa wiadomość
                10, 4, 100, 2         // malt, hops, water, yeast
        );

        // Wywołanie drugiej metody z dużą liczbą parametrów
        bad.processInventoryAndNotifications(
                "Test operacji magazynowej",
                5,
                3,
                true,
                true,
                inventory
        );

        System.out.println("=== KONIEC TESTU: BadBreweryOrchestrator ===\n");
    }
}
