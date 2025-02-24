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


package org.gabriMiao.personal;

import org.gabriMiao.personal.classes.ConcretePetriNet;
import org.gabriMiao.personal.interfaces.PetriNet;
import org.gabriMiao.personal.interfaces.PetriNetBuilder;

public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder();
        builder.setPetriNetName("My Java Petri Net");
        builder.createArch(1, "p1", 2, "t1", true);
        builder.createArch(1, "p2", 0, "t1", false);
        PetriNet pNet = builder.build();
        System.out.println(pNet);
        pNet.fireTransition("t1");
        System.out.println(pNet);
    }
}