package org.gabriMiao.personal.classes;

import org.gabriMiao.personal.interfaces.Transition;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record ConcreteTransition(@NotNull String name) implements Transition {

    @Override
    public @NotNull String name() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ConcreteTransition concreteTransition)) return false;
        return concreteTransition.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Transition: "+name;
    }
}
