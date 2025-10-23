package brewery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Tydzień 2, Wzorzec Iterator
// Kolekcja partii piwa.
public class BeerBatchCollection implements Iterable<String> {
    private List<String> batches = new ArrayList<>();

    public void addBatch(String batch) {
        batches.add(batch);
    }

    @Override
    public Iterator<String> iterator() {
        return batches.iterator();
    }
}
//Koniec, Tydzień 2