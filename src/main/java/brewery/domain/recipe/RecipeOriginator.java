package brewery.domain.recipe;

// Tydzien 2, Wzorzec Memento 2

public class RecipeOriginator {
    private String malt;
    private String hops;
    private int fermentationDays;

    public void setMalt(String malt) { this.malt = malt; }
    public void setHops(String hops) { this.hops = hops; }
    public void setFermentationDays(int fermentationDays) { this.fermentationDays = fermentationDays; }

    public RecipeMemento save() {
        return new RecipeMemento(malt, hops, fermentationDays);
    }

    public void restore(RecipeMemento memento) {
        malt = memento.getMalt();
        hops = memento.getHops();
        fermentationDays = memento.getFermentationDays();
    }

    @Override
    public String toString() {
        return "Recipe{malt='" + malt + "', hops='" + hops + "', fermentationDays=" + fermentationDays + "}";
    }
}

// Koniec, wzorzec Memento 2