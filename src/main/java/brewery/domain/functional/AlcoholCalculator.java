package brewery.domain.functional;

@FunctionalInterface
public interface AlcoholCalculator {
    double calculate(double originalGravity, double finalGravity);
}