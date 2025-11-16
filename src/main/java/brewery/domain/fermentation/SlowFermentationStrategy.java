package brewery.domain.fermentation;

// Implementacja: dokładna fermentacja.
public class SlowFermentationStrategy implements FermentationStrategy {
    @Override
    public void ferment() {
        System.out.println("Dokładna fermentacja - 14 dni.");
    }
}