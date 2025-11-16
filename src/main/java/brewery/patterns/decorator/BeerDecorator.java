package brewery.patterns.decorator;

// Tydzień 1, Wzorzec Dekorator - klasa abstrakcyjna
// Dekorator pozwala na dynamiczne dodawanie nowych funkcjonalności (składników) do obiektu piwa.
// Ta klasa bazowa definiuje wspólny interfejs dla wszystkich dekoratorów.

import brewery.domain.beer.Beer;

public abstract class BeerDecorator extends Beer {
    protected Beer decoratedBeer;

    public BeerDecorator(Beer decoratedBeer) {
        this.decoratedBeer = decoratedBeer;
    }

    @Override
    public String getName() {
        return decoratedBeer.getName();
    }

    @Override
    public String toString() {
        return decoratedBeer.toString();
    }

    // Metoda clone musi zostać zaimplementowana przez konkretne dekoratory
    public abstract Beer clone();
}
// Koniec, Tydzień 1, Wzorzec Dekorator 1