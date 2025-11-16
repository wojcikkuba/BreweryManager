package brewery.application;

import brewery.patterns.command.Command;

import java.util.Stack;

// Tydzień 2, Wzorzec Command 6 - Invoker
// BrewingController wywołuje polecenia bez znajomości ich implementacji.
// Przechowuje historię, dzięki czemu można cofnąć ostatnie akcje.

public class BrewingController {
    private final Stack<Command> commandHistory = new Stack<>();

    public void performAction(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoLastAction() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            System.out.println("Undoing last action...");
            lastCommand.undo();
        } else {
            System.out.println("No actions to undo.");
        }
    }
}

// Koniec, Tydzień 2, Wzorzec Command 6