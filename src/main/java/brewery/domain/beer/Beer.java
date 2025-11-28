package brewery.domain.beer;

// Tydzien 1, Wzorzec Prototype - klasa bazowa
// Prototype umożliwia klonowanie obiektów piwa bez znajomości ich konkretnych klas.
// Każde piwo może być sklonowane, co pozwala na szybkie tworzenie kopii istniejących receptur.

public abstract class Beer implements Cloneable {
    protected String name;
    protected double alcoholContent;
    protected String style;

    public String getName() {
        return name;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public String getStyle() {
        return style;
    }

    public abstract Beer clone();

    @Override
    public String toString() {
        return "Beer{name'" + name + "', alcoholContent=" + alcoholContent + "%, style'" + style + "'}";
    }
}
//Koniec, Tydzień 1, Wzorzec Prototype 1