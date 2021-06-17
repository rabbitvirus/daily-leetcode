package problem795;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoundedMaxSubarraysTest {

    @Test
    public void shouldFindNumberOfSubarrays() {
        var solution = new BoundedMaxSubarrays();

        var actCnt = solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3);

        assertThat(actCnt, is(3));
    }

}
