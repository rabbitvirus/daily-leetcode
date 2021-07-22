package problem915;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PartitionArrayTest {

    private PartitionArray solution = new PartitionArray();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{5, 0, 3, 8, 6}, 3},
                {new int[]{1, 1, 1, 0, 6, 12}, 4}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldPartitionArray(final int[] nums, final int expIdx) {
        var actIdx = solution.partitionDisjoint(nums);

        assertThat(actIdx, is(expIdx));
    }
}
