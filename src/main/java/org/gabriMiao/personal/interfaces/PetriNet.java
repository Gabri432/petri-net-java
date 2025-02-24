package org.gabriMiao.personal.interfaces;

import org.jetbrains.annotations.NotNull;

public interface PetriNet {

    void fireTransition(@NotNull String transitionName);
    boolean isStrictlyConservative();
}
