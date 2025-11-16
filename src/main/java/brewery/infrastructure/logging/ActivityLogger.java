package brewery.infrastructure.logging;

import brewery.patterns.observer.Observer;

//Tydzień 2, Wzorzec Observer
// Logger jest obserwatorem i wyświetla powiadomienia o zmianach w magazynie.
public class ActivityLogger implements Observer {
    @Override
    public void update(String message) {
        System.out.println("LOG: " + message);
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 4