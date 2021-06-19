package problem307;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumArrayTest {

    @Test
    public void shouldHandleRangedSums() {
        var numArr = new NumArray(new int[]{1, 3, 5});

        var sum1 = numArr.sumRange(0, 2);
        assertThat(sum1, is(9));

        numArr.update(1, 2);

        var sum2 = numArr.sumRange(0, 2);
        assertThat(sum2, is(8));
    }

}
