package org.gabriMiao.personal.interfaces;

import org.jetbrains.annotations.NotNull;

public interface Place {
    int tokens();
    void fireTokens(int quantity);
    void addTokens(int quantity);
    @NotNull String getName();
}
