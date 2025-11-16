package brewery.patterns.command;

// Tydzień 2, Wzorzec Command 3 - ConcreteCommand
// Klasa reprezentuje konkretne polecenie uruchomienia procesu warzenia.

import brewery.domain.production.BrewingUnit;

public class StartBrewingCommand implements Command {
    private BrewingUnit brewingUnit;

    public StartBrewingCommand(BrewingUnit brewingUnit) {
        this.brewingUnit = brewingUnit;
    }

    @Override
    public void execute() {
        brewingUnit.startBrewing();
    }

    @Override
    public void undo() {
        brewingUnit.stopBrewing();
    }
}

// Koniec, Tydzień 2, Wzorzec Command 3