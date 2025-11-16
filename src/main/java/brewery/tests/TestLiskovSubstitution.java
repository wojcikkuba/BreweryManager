package brewery.tests;

import brewery.domain.beer.Beer;
import brewery.domain.beer.Lager;
import brewery.domain.beer.Witbier;
import brewery.domain.production.fermentation.FastFermentationStrategy;
import brewery.domain.production.fermentation.FermentationStrategy;
import brewery.domain.production.fermentation.SlowFermentationStrategy;
import brewery.domain.production.brewing.BrewingUnit;
import brewery.patterns.command.CleanCommand;
import brewery.patterns.command.Command;
import brewery.patterns.command.FillBottlesCommand;
import brewery.patterns.command.StartBrewingCommand;

// Tydzień 3, Podstawienia Liskov
// Testy pokazujące wymienność klas bazowych i pochodnych

public class TestLiskovSubstitution {

    // Test 1: Wymienność Beer i klas pochodnych (Lager, Witbier)
    public static void processBeer(Beer beer) {
        System.out.println("Nazwa: " + beer.getName());
        System.out.println("Typ: " + beer.getStyle());
        System.out.println("Alkohol: " + beer.getAlcoholContent() + "%");
        System.out.println("---");
    }

    // Test 2: Wymienność Command i klas pochodnych
    public static void executeCommand(Command command) {
        System.out.println("Wykonuję komendę...");
        command.execute();
        System.out.println("Komenda wykonana pomyślnie");
        System.out.println("---");
    }

    // Test 3: Wymienność FermentationStrategy i klas pochodnych
    public static void testFermentationStrategy(FermentationStrategy strategy) {
        System.out.println("Testowanie strategii fermentacji...");
        strategy.ferment();
        System.out.println("---");
    }

    public static void main(String[] args) {
        System.out.println("===Demo zasady podstawienia Liskov:===");

        System.out.println("Test 1: Wymienność Beer, Lager, Witbier\n");

        Beer lager1 = new Lager("Pilsner Urquell");
        Beer lager2 = new Lager("Tyskie");
        Beer witbier = new Witbier("Perła Witbier");

        // Klasy pochodne używane zamiast klasy bazowej Beer
        processBeer(lager1);
        processBeer(lager2);
        processBeer(witbier);

        System.out.println("Wszystkie obiekty Beer działają zamiennie\n");

        System.out.println("Test 2: Wymienność Command i klas pochodnych\n");
        BrewingUnit brewingUnit = new BrewingUnit();

        Command cmd1 = new StartBrewingCommand(brewingUnit);
        Command cmd2 = new CleanCommand(brewingUnit);
        Command cmd3 = new FillBottlesCommand(brewingUnit);

        // Klasy pochodne używane zamiast klasy bazowej Command
        executeCommand(cmd1);
        executeCommand(cmd2);
        executeCommand(cmd3);

        System.out.println("Wszystkie komendy działają zamiennie\n");

        System.out.println("Test 3: Wymienność FermentationStrategy i klas pochodnych\n");
        FermentationStrategy slowStrategy = new SlowFermentationStrategy();
        FermentationStrategy fastStrategy = new FastFermentationStrategy();

        // Klasy pochodne używane zamiast klasy bazowej FermentationStrategy
        testFermentationStrategy(slowStrategy);
        testFermentationStrategy(fastStrategy);

        System.out.println("Wszystkie strategie fermentacji działają zamiennie\n");
    }
}

// Koniec, Tydzień 3, Podstawienia Liskov
