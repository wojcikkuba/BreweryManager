package brewery.application;

import brewery.domain.beer.Beer;
import brewery.domain.beer.BeerFactory;
import brewery.domain.functional.AlcoholCalculator;
import brewery.domain.functional.ProductionLog;
import brewery.domain.functional.QualityCheck;
import brewery.domain.recipe.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Tydzien 1, Wzorzec Singleton
// Klasa zarządzająca - Singleton.
public class BreweryManager {
    private static BreweryManager instance;

    private BreweryManager() {}

    public static BreweryManager getInstance() {
        if (instance == null) {
            instance = new BreweryManager();
        }
        return instance;
    }

    public void manage() {
        System.out.println("BreweryManager: Rozpoczynam zarządzanie...");

        processProductionLogic(); // Zadanie Interfejsy
        generateReport();         // Zadanie Strumienie
    }

    public void showStatus() {
        System.out.println("Brewery Manager running: " + this.hashCode());
    }
// Koniec, Tydzien 1, Wzorzec Singleton

    // Tydzień 3, Interfejsy Funkcyjne i Lambdy
    // Użycie 3 interfejsów funkcyjnych (kalkulator, sprawdzanie jakości, logowanie) zaimplementowanych przez lambdy.
    private void processProductionLogic() {
        // 1. Lambda do obliczania alkoholu
        AlcoholCalculator alcCalc = (og, fg) -> (og - fg) * 131.25;

        // 2. Lambda do weryfikacji jakości (czy piwo ma > 4%)
        QualityCheck qualityCheck = beer -> beer != null && beer.getAlcoholContent() > 4.0;

        // 3. Lambda do logowania
        ProductionLog simpleLog = msg -> System.out.println("LOG: " + msg);

        // Użycie
        double result = alcCalc.calculate(1.045, 1.010);
        simpleLog.log("Przewidywane ABV: " + String.format("%.2f", result) + "%");

        try {
            Beer b = BeerFactory.createBeer("lager");
            boolean isOk = qualityCheck.check(b);
            simpleLog.log("Kontrola jakości (" + b.getName() + "): " + (isOk ? "OK" : "SŁABE"));
        } catch (Exception e) {
            simpleLog.log("Błąd fabryki piwa.");
        }
    }
    // Koniec, Tydzień 3, Interfejsy Funkcyjne i Lambdy

    // Tydzień 3, Przetwarzanie Strumieniowe
    // Łączenie trzech kolekcji (piwa, receptury, surowce), filtrowanie i tworzenie raportu String.
    private void generateReport() {
        List<Beer> beers = new ArrayList<>();
        try {
            beers.add(BeerFactory.createBeer("lager"));
            beers.add(BeerFactory.createBeer("witbier"));
        } catch (Exception e) { /* ignoruj */ }

        List<Recipe> recipes = Arrays.asList(
                new Recipe.RecipeBuilder().malt("Pilsner").hops("Marynka").fermentationDays(10).build(),
                new Recipe.RecipeBuilder().malt("Wheat").hops("Sycula").fermentationDays(12).build()
        );

        List<String> rawMaterials = Arrays.asList("Woda", "Drożdże", "Chmiel granulat");

        // Stream łączący nazwy z 3 list
        String report = Stream.of(
                        beers.stream().map(Beer::getName),
                        recipes.stream().map(Recipe::getHops),
                        rawMaterials.stream()
                )
                .flatMap(s -> s)                 // Spłaszczenie strumieni
                .filter(s -> s.length() > 4)     // Filtracja krótkich nazw
                .map(String::toUpperCase)        // Na duże litery
                .sorted()                        // Sortowanie
                .collect(Collectors.joining(", ")); // Złączenie

        System.out.println("Raport produkcji: " + report);
    }
    // Koniec, Tydzień 3, Przetwarzanie Strumieniowe
}