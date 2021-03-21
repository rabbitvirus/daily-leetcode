package problem1396;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;

public class UndergroundSystemTest {

    @Test
    public void shouldRunTestCase1() {
        final UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);

        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        var avg = undergroundSystem.getAverageTime("Paradise", "Cambridge");
        assertThat(avg, is(closeTo(14.0d, 1e-6)));

        avg = undergroundSystem.getAverageTime("Leyton", "Waterloo");
        assertThat(avg, is(closeTo(11.0d, 1e-6)));

        undergroundSystem.checkIn(10, "Leyton", 24);

        avg = undergroundSystem.getAverageTime("Leyton", "Waterloo");
        assertThat(avg, is(closeTo(11.0d, 1e-6)));

        undergroundSystem.checkOut(10, "Waterloo", 38);

        avg = undergroundSystem.getAverageTime("Leyton", "Waterloo");
        assertThat(avg, is(closeTo(12.0d, 1e-6)));
    }

    @Test
    public void shouldRunTestCase2() {
        final UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);

        var avg = undergroundSystem.getAverageTime("Leyton", "Paradise");
        assertThat(avg, is(closeTo(5.0d, 1e-6)));

        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);

        avg = undergroundSystem.getAverageTime("Leyton", "Paradise");
        assertThat(avg, is(closeTo(5.5d, 1e-6)));

        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);

        avg = undergroundSystem.getAverageTime("Leyton", "Paradise");
        assertThat(avg, is(closeTo(6.666667d, 1e-6)));
    }

}
