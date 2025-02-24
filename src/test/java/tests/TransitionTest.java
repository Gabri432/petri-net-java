package tests;

import org.gabriMiao.personal.classes.ConcreteTransition;
import org.gabriMiao.personal.interfaces.Transition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransitionTest {
    @Test
    void testTransition() {
        Transition t = new ConcreteTransition("t1");
        assertThat(t.name()).isEqualTo("t1");
        assertThat(t).isEqualTo(new ConcreteTransition("t1"));
        assertThat(t.toString()).isEqualTo("Transition: t1");
    }
}
