package org.gabriMiao.personal.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface PetriNet {

    void fireTransition(@NotNull String transitionName);
    boolean isStrictlyConservative();
}
