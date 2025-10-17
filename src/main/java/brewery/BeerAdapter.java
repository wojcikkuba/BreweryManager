package brewery;

// Tydzień 1, Wzorzec Adapter - implementacja adaptera
// Adapter opakowuje obiekt klasy Beer, aby był kompatybilny z interfejsem OldBrewingSystem.
// Tłumaczy wywołania metod ze starego systemu na metody zrozumiałe dla obiektu Beer.

public class BeerAdapter implements OldBrewingSystem {
    private Beer beer;

    public BeerAdapter(Beer beer) {
        this.beer = beer;
    }

    @Override
    public void startBrewing(String beerName, double alcohol) {
        // Adaptacja: ignorujemy przekazane parametry i używamy danych z obiektu Beer
        System.out.println("Adapter: Rozpoczynam warzenie przy użyciu starego systemu dla: " + beer.getName());
    }

    @Override
    public String getStatus() {
        // Adaptacja: Zwracamy status na podstawie danych z obiektu Beer
        return "Status: " + beer.getName() + " (" + beer.getStyle() + "), " + beer.getAlcoholContent() + "% ABV - gotowe do butelkowania.";
    }
}
// Koniec, Tydzień 1, Wzorzec Adapter 2