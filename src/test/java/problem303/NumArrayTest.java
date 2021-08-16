package problem303;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumArrayTest {

    @Test
    public void shouldSumNumbers() {
        final NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        var sum1 = numArray.sumRange(0, 2);
        assertThat(sum1, is(1));

        var sum2 = numArray.sumRange(2, 5);
        assertThat(sum2, is(-1));

        var sum3 = numArray.sumRange(0, 5);
        assertThat(sum3, is(-3));
    }

}
