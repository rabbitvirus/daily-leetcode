package problem478;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class RandomPointTest {

    @Test
    public void shouldGenerateRandomPointInsideACirclePlacedCentrallyInCartesianSystem() {
        final RandomPoint generator = new RandomPoint(1.0d, 0.0d, 0.0d);

        final double[] point = generator.randPoint();

        assertThat(point[0], is(lessThanOrEqualTo(1.0d)));
        assertThat(point[1], is(lessThanOrEqualTo(1.0d)));
        assertThat(point[0] * point[0] + point[1] * point[1], is(lessThanOrEqualTo(1.0d)));
    }

    @Test
    public void shouldGenerateRandomPointInsideACirclePlacedNotCentrallyInCartesianSystem() {
        final RandomPoint generator = new RandomPoint(6.0d, 10.0d, -8.0d);

        final double[] point = generator.randPoint();

        assertThat(point[0], allOf(greaterThanOrEqualTo(4.0d), lessThanOrEqualTo(16.0d)));
        assertThat(point[1], allOf(greaterThanOrEqualTo(-14.0d), lessThanOrEqualTo(-2.0d)));
        assertThat((point[0] - 10.0d) * (point[0] - 10.0d) + (point[1] + 8.0d) * (point[1] + 8.0d), is(lessThanOrEqualTo(36.0d)));
    }

}
