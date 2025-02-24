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

import org.gabriMiao.personal.interfaces.OutgoingArch;
import org.gabriMiao.personal.interfaces.Place;
import org.gabriMiao.personal.interfaces.Transition;
import org.jetbrains.annotations.NotNull;

public class ConcreteOutgoingArch implements OutgoingArch {
    private final @NotNull Place place;
    private final @NotNull Transition transition;
    private final int weight;

    public ConcreteOutgoingArch(int weight, @NotNull Place place, @NotNull Transition transition) {
        this.place = place;
        this.transition = transition;
        this.weight = weight;
    }
    @Override
    public int weight() {
        return weight;
    }

    @Override
    public Transition getEntryPoint() {
        return transition;
    }

    @Override
    public Place getExitPoint() {
        return place;
    }

    @Override
    public String toString() {
        return transition.name()+" --"+weight+"--> "+place;
    }
}
