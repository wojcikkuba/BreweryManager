package brewery.domain.beer;

// Tydzień 1, Wzorzec Factory Method
// Factory Method tworzy obiekty piwa bez ujawniania logiki konstrukcji klientowi.
// Pozwala na centralne zarządzanie tworzeniem różnych typów piwa.

public class BeerFactory {
    public static Beer createBeer(String type) {
        switch (type.toLowerCase()) {
            case "lager":
                return new Lager();
            case "witbier":
                return new Witbier();
            default:
                throw new IllegalArgumentException("Unknown beer type: " + type);
        }
    }

    public static Beer createCustomBeer(String type, String customName) {
        switch (type.toLowerCase()) {
            case "lager":
                return new Lager(customName);
            case "witbier":
                return new Witbier(customName);
            default:
                throw new IllegalArgumentException("Unknown beer type: " + type);
        }
    }

    public static void showAvailableTypes() {
        System.out.println("Available beer types: Lager, Witbier");
    }
}
//Koniec, Tydzień 1, Wzorzec Factory Method
