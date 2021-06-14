package problem1710;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaximumUnitsTest {

    private MaximumUnits solution = new MaximumUnits();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4, 8},
                {new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10, 91}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaximumNumberOfUnits(final int[][] boxTypes, final int truckSize, final int expUnits) {
        var actUnits = solution.maximumUnits(boxTypes, truckSize);

        assertThat(actUnits, is(expUnits));
    }

}
