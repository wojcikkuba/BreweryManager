package brewery.state;

// Konkretny stan: Warzenie
public class BrewingStateActive implements BrewingState {
    @Override
    public void handle(BrewingProcess context) {
        System.out.println("Proces warzenia trwa.");
        context.setState(new FermentationState());
    }
}