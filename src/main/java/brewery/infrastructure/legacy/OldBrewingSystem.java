package brewery.infrastructure.legacy;

// Tydzień 1, Wzorzec Adapter - interfejs docelowy (stary system)
// Reprezentuje stary, niekompatybilny interfejs, z którym chcemy zintegrować nasze nowe klasy piwa.

public interface OldBrewingSystem {
    void startBrewing(String beerName, double alcohol);
    String getStatus();
}
// Koniec, Tydzień 1, Wzorzec Adapter 1