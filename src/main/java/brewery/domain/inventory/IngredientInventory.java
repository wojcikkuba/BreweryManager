package brewery.domain.inventory;

import brewery.patterns.observer.Observer;
import brewery.patterns.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Tydzień 2, Wzorzec Observer
// Inventory reprezentuje magazyn surowców browaru, powiadamia obserwatorów o zmieniającym się stanie.
public class IngredientInventory implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int maltQuantity;

    public void setMaltQuantity(int quantity) {
        this.maltQuantity = quantity;
        notifyObservers("Stan słodu zmieniony na: " + maltQuantity);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    private static final int DEFAULT_MALT_AMOUNT = 50;
    private static final int DEFAULT_HOPS_AMOUNT = 20;
    private static final int DEFAULT_WATER_AMOUNT = 999;
    private static final int DEFAULT_YEAST_AMOUNT = 10;
    private final Map<String, Integer> stock = new HashMap<>();
    private void loadDefaultInventory() {
        stock.put("malt", DEFAULT_MALT_AMOUNT);
        stock.put("hops", DEFAULT_HOPS_AMOUNT);
        stock.put("water", DEFAULT_WATER_AMOUNT);
        stock.put("yeast", DEFAULT_YEAST_AMOUNT);
    }
    public IngredientInventory() {
        loadDefaultInventory();
    }

    public void addIngredient(String ingredient, int amount) {
        int newAmount = stock.getOrDefault(ingredient, 0) + amount;
        stock.put(ingredient, newAmount);
        System.out.println("Dodano " + amount + " jednostek składnika: " + ingredient + ". Razem: " + newAmount);
    }

    public boolean useIngredient(String ingredient, int amount) {
        int available = stock.getOrDefault(ingredient, 0);
        if (available < amount) {
            System.out.println("BRAK składnika: " + ingredient
                    + ". Dostępne: " + available + ", potrzebne: " + amount);
            return false;
        }
        stock.put(ingredient, available - amount);
        System.out.println("Użyto " + amount + " jednostek składnika: " + ingredient
                + ". Pozostało: " + (available - amount));
        return true;
    }

    public int getAmount(String ingredient) {
        return stock.getOrDefault(ingredient, 0);
    }

    public void showInventory() {
        System.out.println("\n=== Aktualny stan magazynu składników ===");
        stock.forEach((name, amount) ->
                System.out.println("- " + name + ": " + amount + " jednostek")
        );
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 3