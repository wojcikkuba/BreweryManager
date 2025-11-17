package brewery.application;

// Tydzień 1, Wzorzec Fasada (Facade)
// Fasada dostarcza uproszczony interfejs do złożonego systemu warzenia piwa.
// Zamiast ręcznie tworzyć recepturę i piwo, można użyć jednej metody do uwarzenia standardowego gatunku.

import brewery.domain.beer.Beer;
import brewery.domain.beer.BeerFactory;
import brewery.domain.recipe.Recipe;

public class BrewingFacade {
    private BeerFactory beerFactory;

    public BrewingFacade() {
        this.beerFactory = new BeerFactory();
    }

    /*
    public void brewStandardLager() {
        System.out.println("Rozpoczynanie warzenia standardowego Lagera przy użyciu Fasady");

        // Krok 1: Utworzenie receptury za pomocą Buildera
        Recipe lagerRecipe = new Recipe.RecipeBuilder()
                .malt("Pilsner Malt")
                .hops("Lubelski")
                .fermentationDays(12)
                .build();

        // Krok 2: Utworzenie piwa za pomocą Fabryki
        Beer lager = BeerFactory.createBeer("lager");

        System.out.println("Utworzono piwo: " + lager);
        System.out.println("Na podstawie receptury: " + lagerRecipe);
        System.out.println("Proces warzenia zakończony pomyślnie!");
    }

    public void brewStandardWitbier() {
        System.out.println("Rozpoczynanie warzenia standardowego Witbiera przy użyciu Fasady");

        Recipe witbierRecipe = new Recipe.RecipeBuilder()
                .malt("Wheat Malt")
                .hops("Warszawski")
                .fermentationDays(10)
                .additionalIngredients("Bark")
                .build();

        Beer witbier = BeerFactory.createBeer("witbier");

        System.out.println("Utworzono piwo: " + witbier);
        System.out.println("Na podstawie receptury: " + witbierRecipe);
        System.out.println("Proces warzenia zakończony pomyślnie!");
    }
    */

    // NOWY KOD
    public void brewStandardLager() {
        System.out.println("Rozpoczynanie warzenia standardowego Lagera przy użyciu Fasady");

        // Krok 1: Utworzenie receptury za pomocą Buildera
        Recipe lagerRecipe = new Recipe.RecipeBuilder()
                .malt("Pilsner Malt")
                .hops("Lubelski")
                .fermentationDays(12)
                .build();

        brewSpecificBeer(lagerRecipe, "lager");
    }

    // NOWY KOD
    public void brewStandardWitbier() {
        System.out.println("Rozpoczynanie warzenia standardowego Witbiera przy użyciu Fasady");

        Recipe witbierRecipe = new Recipe.RecipeBuilder()
                .malt("Wheat Malt")
                .hops("Warszawski")
                .fermentationDays(10)
                .additionalIngredients("Bark")
                .build();

        brewSpecificBeer(witbierRecipe, "witbier");
    }

    // NOWA METODA
    private void brewSpecificBeer(Recipe recipe, String beerType) {
        Beer beer = BeerFactory.createBeer(beerType);

        System.out.println("Utworzono piwo: " + beer);
        System.out.println("Na podstawie receptury: " + recipe);
        System.out.println("Proces warzenia zakończony pomyślnie!");
    }
}
// Koniec, Tydzień 1, Wzorzec Fasada