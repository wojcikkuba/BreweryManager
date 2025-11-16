package brewery.domain.production.fermentation;

// Implementacja: dokładna fermentacja.
public class SlowFermentationStrategy implements FermentationStrategy {

    private static final int SLOW_FERMENTATION_DAYS = 14;

    @Override
    public void ferment() {
        System.out.println("Dokładna fermentacja - " + SLOW_FERMENTATION_DAYS + " dni.");
    }
}