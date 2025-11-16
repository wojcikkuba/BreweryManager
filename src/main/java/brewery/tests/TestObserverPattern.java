package brewery.tests;

import brewery.domain.inventory.IngredientInventory;
import brewery.infrastructure.logging.ActivityLogger;
import brewery.infrastructure.notification.EventNotificationService;

//Tydzień 2, Wzorzec Observer - Test
// Test działania wzorca obserwatora w systemie browaru.
public class TestObserverPattern {
    public static void main(String[] args) {
        IngredientInventory ingredientInventory = new IngredientInventory();

        ActivityLogger activityLogger = new ActivityLogger();
        EventNotificationService notifier = new EventNotificationService();

        ingredientInventory.registerObserver(activityLogger);
        ingredientInventory.registerObserver(notifier);

        System.out.println("Zmiana stanu słodu do 300:");
        ingredientInventory.setMaltQuantity(300);
        System.out.println();

        System.out.println("Zmiana stanu słodu do 150:");
        ingredientInventory.setMaltQuantity(150);
        System.out.println();

        ingredientInventory.removeObserver(activityLogger);

        System.out.println("Zmiana stanu słodu do 100 (tylko notifier odbierze komunikat):");
        ingredientInventory.setMaltQuantity(100);
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 6