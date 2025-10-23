package brewery.state;

//Tydzień 2, Wzorzec State
// Interfejs stanu procesu warzenia.
public interface BrewingState {
    void handle(BrewingProcess context);
}