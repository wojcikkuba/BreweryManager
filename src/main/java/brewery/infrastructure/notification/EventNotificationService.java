package brewery.infrastructure.notification;


import brewery.patterns.observer.Observer;

//Tydzień 2, Wzorzec Observer
// NotificationService wysyła alerty, gdy stan magazynu się zmienia.
public class EventNotificationService implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ALERT: Powiadomienie - " + message);
    }
    public void notifyEvent(String message) {
        System.out.println("[Notification] " + message);
    }
}
//Koniec, Tydzień 2, Wzorzec Observer 5