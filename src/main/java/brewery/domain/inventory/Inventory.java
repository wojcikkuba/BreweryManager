package brewery.domain.inventory;

import brewery.patterns.observer.Observer;
import brewery.patterns.observer.Subject;

import java.util.ArrayList;
import java.util.List;

//Tydzień 2, Wzorzec Observer
// Inventory reprezentuje magazyn surowców browaru, powiadamia obserwatorów o zmieniającym się stanie.
public class Inventory implements Subject {
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
}
//Koniec, Tydzień 2, Wzorzec Observer 3