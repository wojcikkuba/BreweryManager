package brewery;

public class InventoryMediator extends Component {
    public InventoryMediator (Mediator mediator) { super(mediator); }
    public void updateStock() {
        System.out.println("Magazyn aktualizuje stan zapasów.");
    }
    public void detectLowStock() {
        System.out.println("Magazyn wykrywa niski stan zapasów.");
        mediator.notify(this, "lowStock");
    }
}
