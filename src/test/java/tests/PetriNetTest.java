package tests;

import org.gabriMiao.personal.classes.ConcretePetriNet;
import org.gabriMiao.personal.classes.ConcretePlace;
import org.gabriMiao.personal.interfaces.PetriNet;
import org.gabriMiao.personal.interfaces.PetriNetBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PetriNetTest {

    @Test
    void testFireTransition() {
        PetriNetBuilder pNetBuilder = new ConcretePetriNet.Builder();
        pNetBuilder.createArch(1, "p1", 2, "t1", true);
        pNetBuilder.createArch(1, "p2", 0, "t1", false);
        PetriNet pNet = pNetBuilder.build();
        pNet.fireTransition("t1");
        assertThat(pNet.toString()).contains("(p2 : 1)").contains("(p1 : 1)");
    }

    @Test
    void testGetMarking() {
        PetriNetBuilder pNetBuilder = new ConcretePetriNet.Builder();
        pNetBuilder.createArch(1, "p1", 2, "t1", true);
        pNetBuilder.createArch(1, "p2", 0, "t1", false);
        PetriNet pNet = pNetBuilder.build();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p1", 2))).isTrue();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p2", 0))).isTrue();
        pNet.fireTransition("t1");
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p1", 1))).isTrue();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p2", 1))).isTrue();
        pNet.fireTransition("t1");
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p1", 0))).isTrue();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p2", 2))).isTrue();
    }

    @Test
    void testGetMarkingIsTheSameIfNoTransitionCanBeFired() {
        PetriNetBuilder pNetBuilder = new ConcretePetriNet.Builder();
        pNetBuilder.createArch(1, "p1", 0, "t1", true);
        pNetBuilder.createArch(1, "p2", 0, "t1", false);
        PetriNet pNet = pNetBuilder.build();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p1", 0))).isTrue();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p2", 0))).isTrue();
        pNet.fireTransition("t1");
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p1", 0))).isTrue();
        assertThat(pNet.getCurrentMarking().contains(new ConcretePlace("p2", 0))).isTrue();
    }
}
