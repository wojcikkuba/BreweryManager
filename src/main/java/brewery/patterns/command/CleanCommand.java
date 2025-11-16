package brewery.patterns.command;

// Tydzień 2, Wzorzec Command 4 - ConcreteCommand
// Polecenie czyszczenia wyposażenia browaru

import brewery.domain.production.brewing.BrewingUnit;

public class CleanCommand implements Command {
    private BrewingUnit brewingUnit;

    public CleanCommand(BrewingUnit brewingUnit) {
        this.brewingUnit = brewingUnit;
    }

    @Override
    public void execute() {
        brewingUnit.cleanEquipment();
    }

    @Override
    public void undo() {
        System.out.println("Undo cleaning is not applicable");
    }
}

// Koniec, Tydzień 2, Wzorzec Command 4
