package brewery;

// Tydzień 1, Wzorzec Dekorator - implementacja konkretna
// Ten dekorator dodaje "dodatkowy chmiel" do piwa, modyfikując jego nazwę.

public class ExtraHopsDecorator extends BeerDecorator {

    public ExtraHopsDecorator(Beer decoratedBeer) {
        super(decoratedBeer);
    }

    @Override
    public String getName() {
        return super.getName() + " (Extra Hops)";
    }

    @Override
    public double getAlcoholContent() {
        // Dodatkowy chmiel nie zmienia zawartości alkoholu
        return decoratedBeer.getAlcoholContent();
    }

    @Override
    public String getStyle() {
        return decoratedBeer.getStyle();
    }

    @Override
    public String toString() {
        return "Beer{name'" + getName() + "', alcoholContent=" + getAlcoholContent() + "%, style'" + getStyle() + "'}";
    }

    @Override
    public Beer clone() {
        // Klonujemy udekorowane piwo i ponownie je dekorujemy
        return new ExtraHopsDecorator(decoratedBeer.clone());
    }
}
// Koniec, Tydzień 1, Wzorzec Dekorator 2