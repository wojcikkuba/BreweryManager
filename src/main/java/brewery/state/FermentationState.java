package brewery.state;

public class FermentationState implements BrewingState {
    @Override
    public void handle(BrewingProcess context) {
        System.out.println("Fermentacja piwa.");
        context.setState(new BottlingState());
    }
}