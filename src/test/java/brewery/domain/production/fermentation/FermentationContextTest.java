package brewery.domain.production.fermentation;

import brewery.domain.production.fermentation.FermentationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class FermentationContextTest {
    private FermentationContext fermentationContext;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Mock
    private FermentationStrategy mockStrategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fermentationContext = new FermentationContext(mockStrategy);
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testStartFermentation() {
        fermentationContext.startFermentation();
        String output = outputStream.toString();
        assertTrue(output.contains("Rozpoczynam fermentację"));
        verify(mockStrategy).ferment();
    }

    @Test
    void testSetFermentationTemperature() {
        fermentationContext.setFermentationTemperature(25);
        String output = outputStream.toString();
        assertTrue(output.contains("Ustawiono temperaturę fermentacji: 25°C"));
    }

    @Test
    void testSetStrategy() {
        FermentationStrategy newStrategy = new FermentationStrategy() {
            @Override
            public void ferment() {
                System.out.println("New strategy");
            }
        };
        fermentationContext.setStrategy(newStrategy);
        fermentationContext.performFermentation();
        String output = outputStream.toString();
        assertTrue(output.contains("New strategy"));
    }

    @Test
    void testPerformFermentationWithValidStrategy() {
        fermentationContext.performFermentation();
        verify(mockStrategy).ferment();
    }

    @Test
    void testApplyFermentationStrategy() {
        fermentationContext.applyFermentationStrategy();
        verify(mockStrategy).ferment();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
