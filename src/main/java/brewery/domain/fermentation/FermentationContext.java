package brewery.domain.fermentation;

// Kontekst fermentacji
public class FermentationContext {
    private FermentationStrategy strategy;

    public FermentationContext(FermentationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FermentationStrategy strategy) {
        this.strategy = strategy;
    }

    public void performFermentation() {
        strategy.ferment();
    }
}