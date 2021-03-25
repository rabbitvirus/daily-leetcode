package problem923;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThreeSumWithMultiplicityTest {

    private ThreeSumWithMultiplicity solution = new ThreeSumWithMultiplicity();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8, 20},
                {new int[]{1, 1, 2, 2, 2, 2}, 5, 12}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountThreeSumMulti(final int[] arr, final int target, final int expTuples) {
        final int actTuples = solution.threeSumMulti(arr, target);

        assertThat(actTuples, is(expTuples));
    }

}
