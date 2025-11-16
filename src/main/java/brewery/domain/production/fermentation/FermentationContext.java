package brewery.domain.production.fermentation;

import brewery.domain.production.fermentation.operations.FermentationOperations;
import brewery.domain.production.fermentation.FermentationStrategy;

// Kontekst fermentacji
public class FermentationContext implements FermentationOperations {

    private FermentationStrategy strategy;
    private static final int DEFAULT_TEMPERATURE = 20;
    private int temperature = DEFAULT_TEMPERATURE;

    public FermentationContext(FermentationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FermentationStrategy strategy) {
        this.strategy = strategy;
    }

    public void performFermentation() {
        if (strategy != null) {
            strategy.ferment();
        }
    }

    @Override
    public void startFermentation() {
        System.out.println("Rozpoczynam fermentację...");
        applyFermentationStrategy();
    }

    @Override
    public void setFermentationTemperature(int temperature) {
        System.out.println("Ustawiono temperaturę fermentacji: " + temperature + "°C");
        this.temperature = temperature;
    }

    @Override
    public void applyFermentationStrategy() {
        if (strategy != null) {
            strategy.ferment();
        }
    }
}