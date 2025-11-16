package brewery.domain.beer;

//Tydzień 1, Wzorzec Prototype - implementacja konkretna - Witbier
//Konkretna implementacja piwa typu Witbier z możliwością klonowania.

public class Witbier extends Beer {
    public Witbier() {
        this.name = "Craft Witbier";
        this.alcoholContent = 5.2;
        this.style = "Witbier";
    }

    public Witbier(String customName) {
        this.name = customName;
        this.alcoholContent = 5.2;
        this.style = "Witbier";
    }

    @Override
    public Beer clone() {
        Witbier cloned = new Witbier();
        cloned.name = this.name + " (Clone)";
        cloned.alcoholContent = this.alcoholContent;
        cloned.style = this.style;
        return cloned;
    }
}
