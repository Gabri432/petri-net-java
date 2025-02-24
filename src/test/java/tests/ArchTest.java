package tests;

import org.gabriMiao.personal.classes.ConcreteIncomingArch;
import org.gabriMiao.personal.classes.ConcreteOutgoingArch;
import org.gabriMiao.personal.interfaces.IncomingArch;
import org.gabriMiao.personal.interfaces.OutgoingArch;
import org.gabriMiao.personal.interfaces.Place;
import org.gabriMiao.personal.interfaces.Transition;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArchTest {

    @ParameterizedTest
    @CsvSource({
            "1, placeName, transitionName",
            "2, p2, t1"
    })
    void testIncomingAndOutgoingArch(int weight, String placeName, String transitionName) {
        Place pMock = mock();
        Transition tMock = mock();
        IncomingArch incomingArch = new ConcreteIncomingArch(weight, pMock, tMock);
        OutgoingArch outgoingArch = new ConcreteOutgoingArch(weight, pMock, tMock);

        when(pMock.getName()).thenReturn(placeName);
        when(pMock.tokens()).thenReturn(weight);
        when(pMock.toString()).thenReturn("("+placeName+" : "+weight+")");
        when(tMock.name()).thenReturn(transitionName);

        String incomingOutput = pMock +" --"+weight+"--> "+transitionName;
        assertThat(incomingArch.toString()).isEqualTo(incomingOutput);

        String outgoingOutput =  transitionName+" --"+weight+"--> "+pMock;
        assertThat(outgoingArch.toString()).isEqualTo(outgoingOutput);
    }
}
