// Tydzień 4, Testy jednostkowe dla klasy IngredientInventory
// Kompleksowe testy jednostkowe klasy IngredientInventory
// Weryfikacja inicjalizacji magazynu, dodawania i pobierania składników oraz obsługi wyjątków.
package brewery.domain.inventory;

import brewery.patterns.observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class IngredientInventoryTest {
    private IngredientInventory inventory;

    @Mock
    private Observer mockObserver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        inventory = new IngredientInventory();
    }

    @Test
    void testDefaultInventoryInitialization() {
        assertEquals(50, inventory.getAmount("malt"));
        assertEquals(20, inventory.getAmount("hops"));
        assertEquals(999, inventory.getAmount("water"));
        assertEquals(10, inventory.getAmount("yeast"));
    }

    @Test
    void testAddIngredient() {
        inventory.addIngredient("malt", 25);
        assertEquals(75, inventory.getAmount("malt"));
    }

    @Test
    void testUseIngredientSuccessfully() {
        inventory.useIngredient("hops", 5);
        assertEquals(15, inventory.getAmount("hops"));
    }

    @Test
    void testUseIngredientThrowsExceptionWhenInsufficientAmount() {
        assertThrows(IllegalStateException.class, () ->
                inventory.useIngredient("yeast", 20)
        );
        assertEquals(10, inventory.getAmount("yeast"));
    }

    @Test
    void testObserverNotificationWhenMaltQuantityChanges() {
        inventory.registerObserver(mockObserver);
        inventory.setMaltQuantity(100);

        verify(mockObserver).update("Stan słodu zmieniony na: 100");
    }
}

// Koniec, Tydzień 4, Testy jednostkowe dla klasy IngredientInventory