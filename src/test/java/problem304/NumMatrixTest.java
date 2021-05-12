package problem304;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumMatrixTest {

    @Test
    public void shouldFindRegionsSum() {
        var solution = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});

        var sum1 = solution.sumRegion(2, 1, 4, 3);
        assertThat(sum1, is(8));

        var sum2 = solution.sumRegion(1, 1, 2, 2);
        assertThat(sum2, is(11));

        var sum3 = solution.sumRegion(1, 2, 2, 4);
        assertThat(sum3, is(12));
    }

}
