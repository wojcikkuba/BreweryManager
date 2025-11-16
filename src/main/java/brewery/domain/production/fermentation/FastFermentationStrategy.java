package brewery.domain.production.fermentation;

// Implementacja: szybka fermentacja.
public class FastFermentationStrategy implements FermentationStrategy {

    private static final int FAST_FERMENTATION_DAYS = 7;

    @Override
    public void ferment() {
        System.out.println("Szybka fermentacja - " + FAST_FERMENTATION_DAYS + " dni.");
    }
}