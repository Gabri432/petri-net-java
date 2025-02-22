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
    }
}