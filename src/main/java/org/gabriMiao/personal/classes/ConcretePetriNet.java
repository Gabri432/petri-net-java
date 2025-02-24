package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ConcretePetriNet implements PetriNet {
    private final @NotNull Set<Place> places;
    private final @NotNull Set<Transition> transitions;
    private final @NotNull Set<IncomingArch> incomingArches;
    private final @NotNull Set<OutgoingArch> outgoingArches;
    private final @NotNull String name;

    private ConcretePetriNet(Builder builder) {
        this.name = builder.name;
        this.places = builder.places;
        this.transitions = builder.transitions;
        this.incomingArches = builder.incomingArches;
        this.outgoingArches = builder.outgoingArches;
    }

    public static class Builder implements PetriNetBuilder {
        @NotNull String name = "My Petri Net";
        @NotNull Set<Place> places = new HashSet<>();
        @NotNull Set<Transition> transitions = new HashSet<>();
        @NotNull Set<IncomingArch> incomingArches = new HashSet<>();
        @NotNull Set<OutgoingArch> outgoingArches = new HashSet<>();

        @Override
        public void setPetriNetName(@NotNull String name) {
            if (!name.isBlank()) this.name = name;
        }

        @Override
        public void createArch(int weight, @NotNull String placeName, int tokens, @NotNull String transitionName, boolean isEnteringTrans) {
            if (weight <= 0) return;
            Place p = new ConcretePlace(placeName, tokens);
            if (placeName.isBlank() || tokens < 0) return;
            Transition t = new ConcreteTransition(transitionName);
            if (transitionName.isBlank()) return;
            this.places.add(p);
            this.transitions.add(t);
            if (isEnteringTrans) {
                IncomingArch arch = new ConcreteIncomingArch(weight, p, t);
                incomingArches.add(arch);
            }else {
                OutgoingArch arch = new ConcreteOutgoingArch(weight, p, t);
                outgoingArches.add(arch);
            }
        }

        @Override
        public PetriNet build() {
            return new ConcretePetriNet(this);
        }
    }

    @Override
    public void fireTransition(@NotNull String transitionName) {
        for (Transition transition : transitions) {
            if (transition.name().equals(transitionName) && isEnabled(transition)) {
                this.updatePlaces(transition);
                break;
            }
        }
    }

    private boolean isEnabled(Transition t) {
        for (IncomingArch incomingArch : incomingArches) {
            int weight = incomingArch.weight();
            Place place = incomingArch.getEntryPoint();
            Transition transition = incomingArch.getExitPoint();
            if (transition.equals(t) && weight > place.tokens()) return false;
        }
        return true;
    }

    private void updatePlaces(Transition transition) {
        for (IncomingArch incomingArch : incomingArches) {
            int weight = incomingArch.weight();
            Place place = incomingArch.getEntryPoint();
            if (incomingArch.getExitPoint().equals(transition)) {
                this.places.remove(place);
                place.fireTokens(weight);
                this.places.add(place);
            }
        }
        for (OutgoingArch outgoingArch : outgoingArches) {
            int weight = outgoingArch.weight();
            Place place = outgoingArch.getExitPoint();
            if (outgoingArch.getEntryPoint().equals(transition)) {
                this.places.remove(place);
                place.addTokens(weight);
                this.places.add(place);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Net name: ").append(name).append("\n");
        s.append("Incoming arches: ").append("\n");
        for (IncomingArch incomingArch : incomingArches) {
            s.append(incomingArch).append("\n");
        }
        s.append("Outgoing arches: ").append("\n");
        for (OutgoingArch outgoingArch : outgoingArches) {
            s.append(outgoingArch).append("\n");
        }
        return s.toString();
    }
}
