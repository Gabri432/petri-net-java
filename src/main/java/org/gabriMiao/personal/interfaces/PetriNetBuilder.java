package org.gabriMiao.personal.interfaces;

import org.jetbrains.annotations.NotNull;

public interface PetriNetBuilder {
    void setPetriNetName(@NotNull String name);
    void createPlace(@NotNull String name, int tokens);
    void createTransition(@NotNull String name);
    void createArch(int weight, Place place, Transition transition, boolean inOrOut);
}
