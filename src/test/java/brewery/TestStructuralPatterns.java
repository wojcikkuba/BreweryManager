package brewery;

import brewery.application.BrewingFacade;
import brewery.domain.beer.Beer;
import brewery.domain.beer.BeerFactory;
import brewery.infrastructure.legacy.BeerAdapter;
import brewery.infrastructure.legacy.OldBrewingSystem;
import brewery.patterns.decorator.ExtraHopsDecorator;

public class TestStructuralPatterns {
    public static void main(String[] args) {
        System.out.println("=== TESTOWANIE WZORCÓW STRUKTURALNYCH ===\n");

        // 1. Test Wzorca Fasada (Facade)
        System.out.println("1. Test Facade Pattern:");
        BrewingFacade facade = new BrewingFacade();
        facade.brewStandardLager();
        System.out.println();

        // 2. Test Wzorca Dekorator (Decorator)
        System.out.println("2. Test Decorator Pattern:");
        // Tworzymy podstawowe piwo
        Beer myWitbier = BeerFactory.createBeer("witbier");
        System.out.println("Piwo podstawowe: " + myWitbier.getName());

        // Dekorujemy je dodatkowym chmielem
        Beer hoppedWitbier = new ExtraHopsDecorator(myWitbier);
        System.out.println("Po dekoracji: " + hoppedWitbier.getName());
        System.out.println("Pełny opis: " + hoppedWitbier.toString());
        System.out.println();

        // 3. Test Wzorca Adapter (Adapter)
        System.out.println("3. Test Adapter Pattern:");
        // Tworzymy obiekt naszego nowego systemu
        Beer myLager = BeerFactory.createCustomBeer("lager", "Modern Pilsner");

        // Tworzymy adapter, który opakowuje nasz nowy obiekt
        OldBrewingSystem adapter = new BeerAdapter(myLager);

        // Używamy starego interfejsu do interakcji z nowym obiektem
        adapter.startBrewing("Legacy Beer", 5.0); // parametry są ignorowane przez adapter
        System.out.println(adapter.getStatus());
    }
}