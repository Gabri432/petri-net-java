package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.Place;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ConcretePlace implements Place {
    private final @NotNull String name;
    private int tokens = 0;

    public ConcretePlace(@NotNull String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
    }
    @Override
    public int tokens() {
        return tokens;
    }

    @Override
    public void fireTokens(int quantity) {
        if (quantity > 0 && quantity <= tokens) tokens -= quantity;
    }

    @Override
    public void addTokens(int quantity) {
        if (quantity > 0) tokens += quantity;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ConcretePlace concretePlace)) return false;
        return concretePlace.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Place: "+name+" Tokens: "+tokens;
    }
}
