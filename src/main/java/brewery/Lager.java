package brewery;

// Tydzień 2, Wzorzec Prototype - implementacja konkretna - Lager
// Konkretna implementacja piwa typu Lager z możliwością klonowania.

public class Lager extends Beer{
    public Lager() {
        this.name = "Premium Lager";
        this.alcoholContent = 4.8;
        this.style = "Lager";
    }

    public Lager(String customName) {
        this.name = customName;
        this.alcoholContent = 4.8;
        this.style = "Lager";
    }

    @Override
    public Beer clone() {
        Lager cloned = new Lager();
        cloned.name = this.name + " (Clone)";
        cloned.alcoholContent = this.alcoholContent;
        cloned.style = this.style;
        return cloned;
    }
}
//Koniec, Tydzień 1, Wzorzec Prototype 2