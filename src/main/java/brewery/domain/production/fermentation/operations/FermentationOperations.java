package brewery.domain.production.fermentation.operations;

public interface FermentationOperations extends
        TemperatureControlOperations,
        FermentationModeOperations {

    void startFermentation();
}