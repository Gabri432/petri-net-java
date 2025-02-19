package org.gabriMiao.personal.interfaces;

public interface OutgoingArch {
    int weight();
    Transition getEntryPoint();
    Place getExitPoint();
}
