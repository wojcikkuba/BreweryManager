package brewery;

//Tydzień 2, Wzorzec Memento
public class RecipeMemento {
    private final String malt;
    private final String hops;
    private final int fermentationDays;

    public RecipeMemento(String malt, String hops, int fermentationDays) {
        this.malt = malt;
        this.hops = hops;
        this.fermentationDays = fermentationDays;
    }

    public String getMalt() { return malt; }
    public String getHops() { return hops; }
    public int getFermentationDays() { return fermentationDays; }
}

//Koniec, Tydzień 6, Wzorzec Memento 5
