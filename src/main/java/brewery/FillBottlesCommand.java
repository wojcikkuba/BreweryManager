package brewery;

//Tydzień 2, Wzorzec Command 5 - ConcreteCommand
// Polecenie napełniania butelek piwem.

public class FillBottlesCommand implements Command {
    private BrewingUnit brewingUnit;

    public FillBottlesCommand(BrewingUnit brewingUnit) {
        this.brewingUnit = brewingUnit;
    }

    @Override
    public void execute() {
        brewingUnit.fillBottles();
    }

    @Override
    public void undo() {
        System.out.println("Undo bottle filling is not supported");
    }
}
//Koniec, Tydzień 2, Wzorzec Command 5