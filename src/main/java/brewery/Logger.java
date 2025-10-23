package brewery;

//Tydzień 2, Wzorzec Observer
// Logger jest obserwatorem i wyświetla powiadomienia o zmianach w magazynie.
public class Logger implements Observer {
    @Override
    public void update(String message) {
        System.out.println("LOG: " + message);
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 4