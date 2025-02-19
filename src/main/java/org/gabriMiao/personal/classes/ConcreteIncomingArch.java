package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.IncomingArch;
import org.gabriMiao.personal.interfaces.Place;
import org.gabriMiao.personal.interfaces.Transition;

public class ConcreteIncomingArch implements IncomingArch {

    public ConcreteIncomingArch(int weight, Place place, Transition transition) {}
    @Override
    public int weight() {
        return 0;
    }

    @Override
    public Place getEntryPoint() {
        return null;
    }

    @Override
    public Transition getExitPoint() {
        return null;
    }
}
