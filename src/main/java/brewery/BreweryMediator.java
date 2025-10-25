package brewery;

public class BreweryMediator implements Mediator {
    private ProductionUnit production;
    private Inventory inventory;

    public void setProduction(ProductionUnit production) { this.production = production; }
    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    @Override
    public void notify(Component sender, String event) {
        if (sender == production && "finishedBatch".equals(event)) {
            System.out.println("Mediator: Produkcja zakończyła partię, aktualizuję magazyn.");
            inventory.updateStock();
        }
        else if (sender == inventory && "lowStock".equals(event)) {
            System.out.println("Mediator: Niski stan magazynu, powiadamiam produkcję.");
            production.slowDownProduction();
        }
    }
}
