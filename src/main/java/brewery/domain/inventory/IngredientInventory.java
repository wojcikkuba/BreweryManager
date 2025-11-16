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
    private final Map<String, Integer> stock = new HashMap<>();

    public IngredientInventory() {
        stock.put("malt", 50);
        stock.put("hops", 20);
        stock.put("water", 999);
        stock.put("yeast", 10);
    }

    public boolean takeIngredient(String name, int amount) {
        int current = stock.getOrDefault(name, 0);
        if (current < amount) {
            System.out.println("[Inventory] Not enough " + name);
            return false;
        }
        stock.put(name, current - amount);
        System.out.println("[Inventory] Took " + amount + " of " + name + ", left: " + stock.get(name));
        return true;
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 3