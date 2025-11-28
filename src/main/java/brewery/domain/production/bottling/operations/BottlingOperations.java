package brewery.domain.production.bottling.operations;

public interface BottlingOperations extends
        CleaningOperations,
        SealingOperations,
        LabelingOperations {

    void startBottlingProcess();
}
