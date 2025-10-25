package brewery;

// Tydzien 2, wzorzec Memento 3

import java.util.Stack;

public class RecipeCaretaker {
    private Stack<RecipeMemento> history = new Stack<>();

    public void saveState(RecipeOriginator originator) {
        history.push(originator.save());
    }

    public void undo(RecipeOriginator originator) {
        if (!history.isEmpty()) {
            originator.restore(history.pop());
        }
    }
}

// Koniec, Tydzien 2, wzorzec Memento 3