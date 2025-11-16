package brewery.application;

// Tydzien 1, Wzorzec Singleton
// Singleton zapewnia, że klasa BreweryManager ma tylko jedną instancję w całej aplikacji.
// Centralny punkt zarządzania browarem, dostępny globalnie bez możliwości tworzenia wielu instancji.

public class BreweryManager {
    private static BreweryManager instance;

    private BreweryManager(){

    }

    public static BreweryManager getInstance() {
        if (instance == null) {
            instance = new BreweryManager();
        }
        return instance;
    }

    public void manage() {
        System.out.println("Managing brewery operations...");
    }

    public void showStatus() {
        System.out.println("Brewery Manager is running - Instance: " + this.hashCode());
    }
}
// Koniec, Tydzien 1, Wzorzec Singleton