package de.gaalop.gapp.importing.parallelObjects;

import de.gaalop.dfg.MultivectorComponent;

/**
 *
 * @author Christian Steinmetz
 */
public class MvComponent extends ParallelObject {

    private MultivectorComponent multivectorComponent;

    public MvComponent(MultivectorComponent multivectorComponent) {
        this.multivectorComponent = multivectorComponent;
    }

    public MultivectorComponent getMultivectorComponent() {
        return multivectorComponent;
    }

    public void setMultivectorComponent(MultivectorComponent multivectorComponent) {
        this.multivectorComponent = multivectorComponent;
    }

    @Override
    public Object accept(ParallelObjectVisitor visitor, Object arg) {
        return visitor.visitMvComponent(this, arg);
    }

    @Override
    public String toString() {
        return multivectorComponent.toString();
    }



}
