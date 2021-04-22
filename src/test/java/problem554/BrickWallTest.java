package problem554;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BrickWallTest {

    @Test
    public void shouldFindMinNumberOfCrosses() {
        var solution = new BrickWall();

        var min = solution.leastBricks(List.of(
                List.of(1, 2, 2, 1),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 4),
                List.of(3, 1, 2),
                List.of(1, 3, 1, 1)
        ));

        assertThat(min, is(2));
    }

}
