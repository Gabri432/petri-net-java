package org.gabriMiao.personal.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface PetriNet {

    void fireTransition(@NotNull String transitionName);
    Set<Place> getCurrentMarking();
}
