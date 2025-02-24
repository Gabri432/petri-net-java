package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.OutgoingArch;
import org.gabriMiao.personal.interfaces.Place;
import org.gabriMiao.personal.interfaces.Transition;
import org.jetbrains.annotations.NotNull;

public class ConcreteOutgoingArch implements OutgoingArch {
    private final @NotNull Place place;
    private final @NotNull Transition transition;
    private final int weight;

    public ConcreteOutgoingArch(int weight, @NotNull Place place, @NotNull Transition transition) {
        this.place = place;
        this.transition = transition;
        this.weight = weight;
    }
    @Override
    public int weight() {
        return weight;
    }

    @Override
    public Transition getEntryPoint() {
        return transition;
    }

    @Override
    public Place getExitPoint() {
        return place;
    }

    @Override
    public String toString() {
        return transition.name()+" --"+weight+"--> "+place;
    }
}
