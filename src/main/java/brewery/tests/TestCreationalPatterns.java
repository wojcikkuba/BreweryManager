package brewery.tests;

import brewery.application.BreweryManager;
import brewery.domain.beer.Beer;
import brewery.domain.beer.BeerFactory;
import brewery.domain.recipe.Recipe;

public class TestCreationalPatterns {
    public static void main(String[] args) {
        System.out.println("=== TESTOWANIE WZORCÓW KREACYJNYCH ===\n");

        // Test Singleton
        System.out.println("1. Test Singleton Pattern:");
        BreweryManager manager1 = BreweryManager.getInstance();
        BreweryManager manager2 = BreweryManager.getInstance();

        manager1.showStatus();
        manager2.showStatus();
        System.out.println("Czy to ta sama instancja? " + (manager1 == manager2));
        System.out.println();

        // Test Factory Method
        System.out.println("2. Test Factory Method Pattern:");
        BeerFactory.showAvailableTypes();

        Beer lager = BeerFactory.createBeer("lager");
        Beer witbier = BeerFactory.createBeer("witbier");
        Beer customLager = BeerFactory.createCustomBeer("lager", "Bavarian Gold");

        System.out.println("Utworzone piwa:");
        System.out.println("- " + lager);
        System.out.println("- " + witbier);
        System.out.println("- " + customLager);
        System.out.println();

        // Test Prototype
        System.out.println("3. Test Prototype Pattern:");
        Beer originalLager = BeerFactory.createBeer("lager");
        Beer clonedLager = originalLager.clone();

        System.out.println("Oryginał: " + originalLager);
        System.out.println("Klon: " + clonedLager);
        System.out.println("Czy to różne obiekty? " + (originalLager != clonedLager));
        System.out.println();

        // Test Builder
        System.out.println("4. Test Builder Pattern:");
        Recipe simpleRecipe = new Recipe.RecipeBuilder()
                .malt("Pilsner Malt")
                .hops("Saaz")
                .fermentationDays(10)
                .build();

        Recipe complexRecipe = new Recipe.RecipeBuilder()
                .malt("Vienna Malt")
                .hops("Cascade")
                .fermentationDays(14)
                .temperature(16.5)
                .yeast("Belgian Yeast")
                .additionalIngredients("Orange peel, Coriander")
                .build();

        System.out.println("Prosta receptura: " + simpleRecipe);
        System.out.println("Złożona receptura: " + complexRecipe);
    }
}
