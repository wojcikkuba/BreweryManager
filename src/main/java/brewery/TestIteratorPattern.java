package brewery;

import java.util.Iterator;

public class TestIteratorPattern {
    public static void main(String[] args) {
        System.out.println("\n3. Test wzorca Iterator:");
        BeerBatchCollection batches = new BeerBatchCollection();
        batches.addBatch("Partia #1");
        batches.addBatch("Partia #2");
        batches.addBatch("Partia #3");
        Iterator<String> iterator = batches.iterator();
        while (iterator.hasNext()) {
            System.out.println("Przetwarzam: " + iterator.next());
        }
    }
}
