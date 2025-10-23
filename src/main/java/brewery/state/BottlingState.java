package brewery.state;

public class BottlingState implements BrewingState {
    @Override
    public void handle(BrewingProcess context) {
        System.out.println("Butelkowanie gotowego piwa.");
        context.setState(null);  // Koniec procesu
    }
}
