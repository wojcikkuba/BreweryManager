package brewery.domain.recipe;

//Tydzień 1, Wzorzec Builder
//Builder pozwala na etapowe konstruowanie złożonego obiektu receptury piwa.
//Umożliwia tworzenie receptur z opcjonalnymi składnikami w czytelny sposób.

public class Recipe {
    private String malt;
    private String hops;
    private int fermentationDays;
    private double temperature;
    private String yeast;
    private String additionalIngredients;

    private Recipe(RecipeBuilder builder) {
        this.malt = builder.malt;
        this.hops = builder.hops;
        this.fermentationDays = builder.fermentationDays;
        this.temperature = builder.temperature;
        this.yeast = builder.yeast;
        this.additionalIngredients = builder.additionalIngredients;
    }

    // Gettery
    public String getMalt() { return malt; }
    public String getHops() { return hops; }
    public int getFermentationDays() { return fermentationDays; }
    public double getTemperature() { return temperature; }
    public String getYeast() { return yeast; }
    public String getAdditionalIngredients() { return additionalIngredients; }

    public static class RecipeBuilder {
        private String malt;
        private String hops;
        private int fermentationDays;
        private double temperature = 18.0; // domyślna temperatura
        private String yeast = "Standard Yeast"; // domyślne drożdże
        private String additionalIngredients = "None";

        public RecipeBuilder malt(String malt) {
            this.malt = malt;
            return this;
        }

        public RecipeBuilder hops(String hops) {
            this.hops = hops;
            return this;
        }

        public RecipeBuilder fermentationDays(int days) {
            this.fermentationDays = days;
            return this;
        }

        public RecipeBuilder temperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        public RecipeBuilder yeast(String yeast) {
            this.yeast = yeast;
            return this;
        }

        public RecipeBuilder additionalIngredients(String ingredients) {
            this.additionalIngredients = ingredients;
            return this;
        }

        public Recipe build() {
            if (malt == null || hops == null || fermentationDays <= 0) {
                throw new IllegalStateException("Malt, hops and fermentation days are required");
            }
            return new Recipe(this);
        }
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "malt='" + malt + '\'' +
                ", hops='" + hops + '\'' +
                ", fermentationDays=" + fermentationDays +
                ", temperature=" + temperature + "°C" +
                ", yeast='" + yeast + '\'' +
                ", additionalIngredients='" + additionalIngredients + '\'' +
                '}';
    }
}
// Koniec, Tydzień 1, Wzorzec Builder
