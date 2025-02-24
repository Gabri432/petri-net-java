package tests;

import org.gabriMiao.personal.classes.ConcretePetriNet;
import org.gabriMiao.personal.interfaces.PetriNet;
import org.gabriMiao.personal.interfaces.PetriNetBuilder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PetriNetBuilderTest {
    @Test
    void testPetriNetBuilder() {
        PetriNetBuilder pNetBuilder = new ConcretePetriNet.Builder();
        pNetBuilder.setPetriNetName("My Amazing Petri Net for testing");
        pNetBuilder.createArch(1, "p1", 2, "t1", true);
        pNetBuilder.createArch(1, "p2", 2, "t1", false);
        PetriNet pNet = pNetBuilder.build();
        assertThat(pNet.toString()).contains("My Amazing Petri Net for testing")
                .contains("(p1 : 2) --1--> t1")
                .contains("t1 --1--> (p2 : 2)")
                .contains("(p1 : 2)(p2 : 2)");
    }
}
