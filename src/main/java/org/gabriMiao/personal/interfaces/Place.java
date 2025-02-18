package org.gabriMiao.personal.interfaces;

public interface Place {
    Transition[] preSet();
    Transition[] postSet();
    int tokens();
    void fireTokens();
}
