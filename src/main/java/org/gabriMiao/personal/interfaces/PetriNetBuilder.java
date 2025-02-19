package org.gabriMiao.personal.interfaces;

import org.jetbrains.annotations.NotNull;

public interface PetriNetBuilder {
    void setPetriNetName(@NotNull String name);
    void createArch(int weight, @NotNull String placeName, int tokens, @NotNull String transitionName, boolean inOrOut);
}
