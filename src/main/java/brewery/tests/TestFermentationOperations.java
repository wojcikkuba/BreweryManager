package brewery.tests;

import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.FermentationContext;
import brewery.domain.production.fermentation.SlowFermentationStrategy;

public class TestFermentationOperations {
    public static void main(String[] args) {

        System.out.println("\nTest fermentacji:");

        System.out.println("\nSzybka:");
        FermentationContext fast = new FermentationContext(new FastFermentationStrategy());
        fast.setFermentationTemperature(24);
        fast.startFermentation();
        fast.applyFermentationStrategy();

        System.out.println("\nWolna:");
        FermentationContext slow = new FermentationContext(new SlowFermentationStrategy());
        slow.setFermentationTemperature(18);
        slow.startFermentation();

    }
}
