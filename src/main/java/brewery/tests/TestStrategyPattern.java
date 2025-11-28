package brewery.tests;

import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.fermentation.SlowFermentationStrategy;

public class TestStrategyPattern {
    public static void main(String[] args) {

        System.out.println("Test wzorca Strategy:");
        FermentationContext fermentation = new FermentationContext(new FastFermentationStrategy());
        fermentation.performFermentation();
        fermentation.setStrategy(new SlowFermentationStrategy());
        fermentation.performFermentation();
    }
}
