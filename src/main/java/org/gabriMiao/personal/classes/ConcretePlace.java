/*
* Copyright 2025 Gabriele Gatti

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/


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
        if (concretePlace.tokens != tokens) return false;
        return concretePlace.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tokens);
    }

    @Override
    public String toString() {
        return "("+name+" : "+tokens +")";
    }
}
