package brewery.patterns.observer;

//Tydzień 2, Wzorzec Observer
// Subject zarządza listą obserwatorów i powiadamia ich o zmianach.
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
//Koniec, Tydzień 2, Wzorzec Observer 2