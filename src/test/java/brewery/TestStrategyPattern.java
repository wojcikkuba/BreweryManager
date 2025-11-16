package brewery;

import brewery.domain.fermentation.FastFermentationStrategy;
import brewery.domain.fermentation.FermentationContext;
import brewery.domain.fermentation.SlowFermentationStrategy;

public class TestStrategyPattern {
    public static void main(String[] args) {

        System.out.println("Test wzorca Strategy:");
        FermentationContext fermentation = new FermentationContext(new FastFermentationStrategy());
        fermentation.performFermentation();
        fermentation.setStrategy(new SlowFermentationStrategy());
        fermentation.performFermentation();
    }
}
