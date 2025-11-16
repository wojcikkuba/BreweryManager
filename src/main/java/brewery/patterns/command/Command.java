package brewery.patterns.command;

// Tydzien 2, Wzorzec Command 1
// Interfejs Command reprezentuje abstrakcję akcji, którą można wykonać i ewentualnie cofnąć

public interface Command {
    void execute();
    void undo();
}

// Koniec, Tydzień 2, Wzorzec Command 1
