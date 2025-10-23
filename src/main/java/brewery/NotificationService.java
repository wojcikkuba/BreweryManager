package brewery;


//Tydzień 2, Wzorzec Observer
// NotificationService wysyła alerty, gdy stan magazynu się zmienia.
public class NotificationService implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ALERT: Powiadomienie - " + message);
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 5