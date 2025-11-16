package brewery;

import brewery.domain.inventory.Inventory;
import brewery.infrastructure.logging.Logger;
import brewery.infrastructure.notification.NotificationService;

//Tydzień 2, Wzorzec Observer - Test
// Test działania wzorca obserwatora w systemie browaru.
public class TestObserverPattern {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Logger logger = new Logger();
        NotificationService notifier = new NotificationService();

        inventory.registerObserver(logger);
        inventory.registerObserver(notifier);

        System.out.println("Zmiana stanu słodu do 300:");
        inventory.setMaltQuantity(300);
        System.out.println();

        System.out.println("Zmiana stanu słodu do 150:");
        inventory.setMaltQuantity(150);
        System.out.println();

        inventory.removeObserver(logger);

        System.out.println("Zmiana stanu słodu do 100 (tylko notifier odbierze komunikat):");
        inventory.setMaltQuantity(100);
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 6