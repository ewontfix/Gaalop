package de.gaalop.gapp.instructionSet;

import de.gaalop.gapp.PosSelectorset;
import de.gaalop.gapp.Selectorset;
import de.gaalop.gapp.variables.GAPPMultivector;
import de.gaalop.gapp.variables.GAPPSetOfVariables;
import de.gaalop.gapp.visitor.GAPPVisitor;

/**
 * Represents the addMv command in the GAPP IR.
 *
 * Description from the paper:
 * Copies the selected blades from multivector mvsrc to
 * multivector mvdest . dest0 , src0 , dest1 , src1 , up to dest31
 * and src31 , are blade selectors. Note that it is invalid
 * language syntax to have more than one source multivector
 * speciﬁed in this command. To copy elements from
 * several multivectors it is required to use multiple setMv
 * commands, one for each multivector. This command is
 * restricted to one source and destination multivector.
 */
public class GAPPSetMv extends GAPPBaseInstruction {

    private GAPPMultivector destinationMv;
    private GAPPSetOfVariables source;
    private PosSelectorset selectorsDest;
    private Selectorset selectorsSrc;

    public GAPPSetMv(GAPPMultivector destinationMv, GAPPSetOfVariables source, PosSelectorset selectorsDest, Selectorset selectorsSrc) {
        this.destinationMv = destinationMv;
        this.source = source;
        this.selectorsDest = selectorsDest;
        this.selectorsSrc = selectorsSrc;
        assert (selectorsDest.size() == selectorsSrc.size());

    }

    @Override
    public Object accept(GAPPVisitor visitor, Object arg) {
        return visitor.visitSetMv(this, arg);
    }

    public GAPPMultivector getDestinationMv() {
        return destinationMv;
    }

    public PosSelectorset getSelectorsDest() {
        return selectorsDest;
    }

    public Selectorset getSelectorsSrc() {
        return selectorsSrc;
    }

    public GAPPSetOfVariables getSource() {
        return source;
    }

    public void setDestinationMv(GAPPMultivector destinationMv) {
        this.destinationMv = destinationMv;
    }

    public void setSelectorsDest(PosSelectorset selectorsDest) {
        this.selectorsDest = selectorsDest;
    }

    public void setSelectorsSrc(Selectorset selectorsSrc) {
        this.selectorsSrc = selectorsSrc;
    }

    public void setSource(GAPPSetOfVariables source) {
        this.source = source;
    }

}
