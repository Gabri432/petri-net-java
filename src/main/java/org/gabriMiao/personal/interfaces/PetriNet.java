package org.gabriMiao.personal.interfaces;

public interface PetriNet {

    boolean checkForIdentifier(Identifier identifier);
    boolean isLimited();
    boolean isConservative();
}
