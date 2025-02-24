package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.IncomingArch;
import org.gabriMiao.personal.interfaces.Place;
import org.gabriMiao.personal.interfaces.Transition;
import org.jetbrains.annotations.NotNull;

public class ConcreteIncomingArch implements IncomingArch {
    private final @NotNull Place place;
    private final @NotNull Transition transition;
    private final int weight;

    public ConcreteIncomingArch(int weight, @NotNull Place place, @NotNull Transition transition) {
        this.place = place;
        this.transition = transition;
        this.weight = weight;
    }
    @Override
    public int weight() {
        return weight;
    }

    @Override
    public Place getEntryPoint() {
        return place;
    }

    @Override
    public Transition getExitPoint() {
        return transition;
    }

    @Override
    public String toString() {
        return place+" --"+weight+"--> "+transition.name();
    }
}
