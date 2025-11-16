package brewery.domain.production.process;

// Konkretny stan: Przygotowanie
public class PreparationState implements BrewingState {
    @Override
    public void handle(BrewingProcess context) {
        System.out.println("Przygotowanie składników.");
        context.setState(new BrewingStateActive());
    }
}