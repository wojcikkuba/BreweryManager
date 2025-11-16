package brewery.domain.production.process;
// Kontekst procesu warzenia

public class BrewingProcess {
    private BrewingState state;

    public BrewingProcess() {
        this.state = new PreparationState();
    }

    public void setState(BrewingState state) {
        this.state = state;
    }

    public void nextStep() {
        if(state != null)
            state.handle(this);
        else
            System.out.println("Proces warzenia zakończony.");
    }
}