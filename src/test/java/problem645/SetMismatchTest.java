package problem645;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SetMismatchTest {

    private SetMismatch sm = new SetMismatch();

    @DataProvider(name = "dp1")
    public static Object[][] testData() {
        return new Object[][]{
                {new int[]{1, 2, 2, 4}, new int[]{2, 3}},
                {new int[]{1, 1}, new int[]{1, 2}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindErrorNums(final int[] nums, final int[] expRes) {
        final int[] actRes = sm.findErrorNums(nums);

        assertThat(actRes, is(expRes));
    }

}