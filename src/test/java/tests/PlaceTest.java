package tests;

import org.gabriMiao.personal.classes.ConcretePlace;
import org.gabriMiao.personal.interfaces.Place;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceTest {

    @Test
    void testFireTokens() {
        Place place = new ConcretePlace("p1", 3);
        place.fireTokens(3);
        assertThat(place.tokens()).isEqualTo(0);
    }

    @Test
    void testAddTokens() {
        Place place = new ConcretePlace("p1", 3);
        place.addTokens(3);
        assertThat(place.tokens()).isEqualTo(6);
    }
}
