package brewery;

import brewery.domain.beer.Beer;
import brewery.domain.inventory.IngredientInventory;
import brewery.domain.production.brewing.BrewingUnit;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.SlowFermentationStrategy;
import brewery.domain.production.fermentation.FermentationStrategy;
import brewery.domain.production.process.BottlingState;
import brewery.domain.production.process.BrewingProcess;
import brewery.infrastructure.notification.EventNotificationService;

/**
 * Klasa wykonuje wiele różnych zadań związanych z procesem produkcji piwa.
 * Zawiera nadmiarowe komentarze, nieużywane zmienne, powtórzenia kodu
 * oraz kilka długich metod o szerokim zakresie odpowiedzialności.
 */
public class BadBreweryOrchestrator {

    private int x = 0;                 // przykładowa zmienna licznikowa
    private String tmp;                // pomocnicze pole tekstowe
    private boolean flag = false;      // pomocnicza flaga

    private BrewingUnit brewingUnit;
    private FermentationContext fermentationContext;
    private IngredientInventory inventory;
    private EventNotificationService notificationService;
    private BrewingProcess brewingProcess;

    public BadBreweryOrchestrator(BrewingUnit unit,
                                  FermentationContext context,
                                  IngredientInventory inventory,
                                  EventNotificationService notificationService,
                                  BrewingProcess brewingProcess) {

        this.brewingUnit = unit;
        this.fermentationContext = context;
        this.inventory = inventory;
        this.notificationService = notificationService;
        this.brewingProcess = brewingProcess;

        this.tmp = "initialized";
        this.x = 1;
        this.x = 2; // nadpisanie poprzedniej wartości
    }

    /**
     * Metoda realizuje wiele etapów procesu:
     * - pobiera dane o piwie,
     * - wypisuje informacje,
     * - wywołuje operacje warzenia, fermentacji i butelkowania,
     * - wykonuje operacje na magazynie oraz powiadomienia.
     * Zawiera dużą liczbę parametrów i jest trudna do śledzenia.
     */
    public void doAllStuffInBrewery(Beer beer,
                                    boolean useFastFermentation,
                                    int fermentationTemperature,
                                    boolean sendNotifications,
                                    String additionalMessage,
                                    int malt,        // ilość słodu
                                    int hops,        // ilość chmielu
                                    int water,       // ilość wody
                                    int yeast) {     // ilość drożdży

        int localCounter = 0;
        localCounter = localCounter + 1; // inkrementacja lokalna

        // podstawowe informacje o piwie
        System.out.println("=== Rozpoczynam proces produkcji: " + beer.getName() + " ===");
        System.out.println("Styl: " + beer.getStyle());
        System.out.println("Styl: " + beer.getStyle()); // powtórzenie

        double alc = beer.getAlcoholContent();
        alc = beer.getAlcoholContent(); // powtórne przypisanie

        // stan magazynu
        inventory.showInventory();
        System.out.println("Surowce wejściowe: malt=" + malt + ", hops=" + hops + ", water=" + water + ", yeast=" + yeast);

        // pomocnicze wywołanie, nie wpływa na logikę
        logProcessStart(beer.getName(), malt + hops + water + yeast);

        if (true) {
            System.out.println("Rozpoczynam etap podgrzewania.");
        }

        brewingUnit.startBrewing();

        brewingUnit.prepareIngredients();
        brewingUnit.prepareIngredients(); // powtórzenie

        brewingUnit.prepareBrewingEquipment();
        brewingUnit.prepareBrewingEquipment(); // powtórzenie

        brewingUnit.mixRawIngredients();

        brewingUnit.increaseTemperature(25);
        brewingUnit.increaseTemperature(25); // powtórzenie

        brewingUnit.increaseTemperature(fermentationTemperature);

        brewingProcess.nextStep();
        brewingProcess.nextStep();

        FermentationStrategy strategy;
        if (useFastFermentation == true) {
            strategy = new FastFermentationStrategy();
        } else if (useFastFermentation == false) {
            strategy = new SlowFermentationStrategy();
            flag = true;
        } else {
            strategy = new FastFermentationStrategy(); // nieosiągalna gałąź, ale pozostawiona
        }

        fermentationContext.setStrategy(strategy);
        fermentationContext.setFermentationTemperature(fermentationTemperature);
        fermentationContext.startFermentation();
        fermentationContext.applyFermentationStrategy();

        BottlingState bottlingState = new BottlingState();
        bottlingState.performCleaning();
        bottlingState.labelBottle();
        bottlingState.sealBottle();
        bottlingState.startBottlingProcess();

        if (additionalMessage != null) {
            if (additionalMessage.length() > 0) {
                System.out.println("Dodatkowa wiadomość: " + additionalMessage);
            }
        }

        if (sendNotifications) {
            if (notificationService != null) {
                notificationService.notifyEvent("Zakończono proces dla piwa: " + beer.getName());
            }
        } else {
            if (!sendNotifications) {
                System.out.println("Powiadomienia nie zostały wysłane.");
            }
        }

        // dodatkowa, zbędna operacja na polu x
        x = x + localCounter;
        x = x - 1;

        brewingUnit.cleanEquipment();
        brewingUnit.stopBrewing();
        brewingUnit.stopBrewing(); // powtórzenie

        System.out.println("=== Proces zakończony ===");
        System.out.println("=== Proces zakończony ==="); // powtórzenie
    }

    /**
     * Metoda wykonuje operacje związane z magazynem i powiadomieniami.
     * Przyjmuje kilka parametrów, część z nich jest wykorzystywana tylko do wypisywania informacji.
     */
    public void processInventoryAndNotifications(String description,
                                                 int value1,
                                                 int value2,
                                                 boolean showInventory,
                                                 boolean sendEvent,
                                                 IngredientInventory inventoryOverride) {

        System.out.println("Opis operacji: " + description);
        System.out.println("Pierwsza wartość: " + value1);
        System.out.println("Druga wartość: " + value2);

        int sum = value1 + value2;
        int diff = value1 - value2; // różnica wyliczona, ale nieużywana
        sum = sum + 0; // zbędna operacja

        if (showInventory) {
            if (inventoryOverride != null) {
                inventoryOverride.showInventory();
            } else if (inventory != null) {
                inventory.showInventory();
            }
        }

        if (sendEvent) {
            if (notificationService != null) {
                notificationService.notifyEvent("Operacja magazynowa: " + description + " (" + sum + ")");
            }
        } else {
            if (!sendEvent && notificationService != null) {
                // nadmiarowy warunek, alternatywny scenariusz wypisania
                notificationService.notifyEvent("Operacja bez wysłania głównego powiadomienia: " + description);
            }
        }
    }

    /**
     * Metoda pomocnicza do wypisywania informacji o rozpoczęciu procesu.
     * Zawiera proste operacje tekstowe.
     */
    private void logProcessStart(String beerName, int totalIngredients) {
        String info = "Start procesu: " + beerName;
        info = info + " | liczba jednostek surowców: " + totalIngredients;
        System.out.println(info);
    }
}
