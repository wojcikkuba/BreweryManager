package brewery.domain.functional;

@FunctionalInterface
public interface ProductionLog {
    void log(String message);
}