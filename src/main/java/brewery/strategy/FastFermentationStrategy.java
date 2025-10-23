package brewery.strategy;

// Implementacja: szybka fermentacja.
public class FastFermentationStrategy implements FermentationStrategy {
    @Override
    public void ferment() {
        System.out.println("Szybka fermentacja - 5 dni.");
    }
}