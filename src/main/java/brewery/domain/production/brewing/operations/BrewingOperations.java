package brewery.domain.production.brewing.operations;

public interface BrewingOperations extends
        PreparationOperations,
        HeatingOperations,
        MixingOperations {

    void startBrewingProcess();
}