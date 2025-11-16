package brewery.domain.production;

import brewery.patterns.composite.Component;
import brewery.patterns.mediator.Mediator;

public class ProductionUnit extends Component {
    public ProductionUnit(Mediator mediator) { super(mediator); }
    public void finishBatch() {
        System.out.println("Produkcja zakończyła partię.");
        mediator.notify(this, "finishedBatch");
    }
    public void slowDownProduction() {
        System.out.println("Produkcja zwalnia tempo z powodu niskich zasobów.");
    }
}
