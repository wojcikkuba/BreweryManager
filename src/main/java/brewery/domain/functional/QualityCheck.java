package brewery.domain.functional;

import brewery.domain.beer.Beer;

@FunctionalInterface
public interface QualityCheck {
    boolean check(Beer beer);
}