package brewery.domain.production.brewing.operations;

public interface HeatingOperations {
    void increaseTemperature(int amount);
    void decreaseTemperature(int amount);
}