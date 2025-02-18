package org.gabriMiao.personal.interfaces;

public interface Transition {

    Place[] preSet();
    Place[] postSet();
    boolean isEnabled();
    void fire();
}
