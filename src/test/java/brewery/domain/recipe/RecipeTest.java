// Tydzień 4, Testy jednostkowe dla klasy Recipe
// Weryfikacja poprawności działania wzorca Builder przy tworzeniu piwa z pełnymi i domyślnymi parametrami
// Obsługa wyjątków IllegalStateException przy brakujących lub nieprawidłowych wymaganych polach

package brewery.domain.recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testRecipeBuilderWithAllParameters() {
        Recipe recipe = new Recipe.RecipeBuilder()
                .malt("Pale Malt")
                .hops("Cascade")
                .fermentationDays(10)
                .temperature(20.0)
                .yeast("Ale Yeast")
                .additionalIngredients("Honey")
                .build();

        assertEquals("Pale Malt", recipe.getMalt());
        assertEquals("Cascade", recipe.getHops());
        assertEquals(10, recipe.getFermentationDays());
        assertEquals(20.0, recipe.getTemperature());
        assertEquals("Ale Yeast", recipe.getYeast());
        assertEquals("Honey", recipe.getAdditionalIngredients());
    }

    @Test
    void testRecipeBuilderWithDefaultValues() {
        Recipe recipe = new Recipe.RecipeBuilder()
                .malt("Pale Malt")
                .hops("Cascade")
                .fermentationDays(7)
                .build();

        assertEquals("Pale Malt", recipe.getMalt());
        assertEquals("Cascade", recipe.getHops());
        assertEquals(7, recipe.getFermentationDays());
        assertEquals(18.0, recipe.getTemperature());
        assertEquals("Standard Yeast", recipe.getYeast());
        assertEquals("None", recipe.getAdditionalIngredients());
    }

    @Test
    void testRecipeBuilderMissingMaltThrowsException() {
        assertThrows(IllegalStateException.class, () ->
                new Recipe.RecipeBuilder()
                        .hops("Cascade")
                        .fermentationDays(7)
                        .build()
        );
    }

    @Test
    void testRecipeBuilderMissingHopsThrowsException() {
        assertThrows(IllegalStateException.class, () ->
                new Recipe.RecipeBuilder()
                        .malt("Pale Malt")
                        .fermentationDays(7)
                        .build()
        );
    }

    @Test
    void testRecipeBuilderInvalidFermentationDaysThrowsException() {
        assertThrows(IllegalStateException.class, () ->
                new Recipe.RecipeBuilder()
                        .malt("Pale Malt")
                        .hops("Cascade")
                        .fermentationDays(0)
                        .build()
        );
    }
}
// Koniec, Tydzień 4, Testy jednostkowe dla klasy Recipe
