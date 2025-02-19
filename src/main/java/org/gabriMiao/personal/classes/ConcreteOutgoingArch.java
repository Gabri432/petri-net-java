package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.OutgoingArch;
import org.gabriMiao.personal.interfaces.Place;
import org.gabriMiao.personal.interfaces.Transition;

public class ConcreteOutgoingArch implements OutgoingArch {

    public ConcreteOutgoingArch(int weight, Place place, Transition transition) {}
    @Override
    public int weight() {
        return 0;
    }

    @Override
    public Transition getEntryPoint() {
        return null;
    }

    @Override
    public Place getExitPoint() {
        return null;
    }
}
