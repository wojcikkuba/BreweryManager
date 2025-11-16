package brewery.patterns.composite;

import brewery.patterns.mediator.Mediator;

public abstract class Component {
    protected Mediator mediator;
    public Component(Mediator mediator) { this.mediator = mediator; }
}
