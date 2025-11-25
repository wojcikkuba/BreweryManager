// Tydzień 4, Testy jednostkowe dla klasy BrewingUnit
// Weryfikacja poprawności działania metod związanych  z procesem warzenia piwa i kontroli temperatury.
// Wykorzystanie ByteArrayOutputStream do przechwycenia i analizy wyjścia konsoli.
package brewery.domain.production.brewing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BrewingUnitTest {
    private BrewingUnit brewingUnit;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        brewingUnit = new BrewingUnit();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testStartBrewing() {
        brewingUnit.startBrewing();
        String output = outputStream.toString();
        assertTrue(output.contains("Brewing unit started the brewing process"));
    }

    @Test
    void testStopBrewing() {
        brewingUnit.stopBrewing();
        String output = outputStream.toString();
        assertTrue(output.contains("Brewing unit stopped the brewing process"));
    }

    @Test
    void testStartBrewingProcess() {
        brewingUnit.startBrewingProcess();
        String output = outputStream.toString();
        assertTrue(output.contains("Uruchamiam pełen proces warzenia"));
        assertTrue(output.contains("Przygotowanie składników"));
        assertTrue(output.contains("Mieszanie składników"));
    }

    @Test
    void testIncreaseTemperature() {
        brewingUnit.increaseTemperature(25);
        String output = outputStream.toString();
        assertTrue(output.contains("Zwiększam temperaturę o 25°C"));
    }

    @Test
    void testDecreaseTemperature() {
        brewingUnit.decreaseTemperature(5);
        String output = outputStream.toString();
        assertTrue(output.contains("Zmniejszam temperaturę o 5°C"));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
// Koniec, Tydzień 4, Testy jednostkowe dla klasy BrewingUnit