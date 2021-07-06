package problem1338;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReduceArraySizeTest {

    private ReduceArraySize solution = new ReduceArraySize();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}, 2},
                {new int[]{7, 7, 7, 7, 7, 7}, 1},
                {new int[]{1, 9}, 1},
                {new int[]{1000, 1000, 3, 7}, 1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5},
                {new int[]{2, 28, 92, 30, 100, 52, 28, 48, 91, 27, 66, 19, 11, 53, 91, 95, 74, 51, 65, 65, 96, 81, 21, 55,
                        98, 3, 2, 89, 99, 57, 78, 34, 50, 2, 57, 76, 23, 90, 89, 36, 53, 22, 73, 59, 95, 45}, 14}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinStepsNumberToReduceArraySize(final int[] arr, final int expNum) {
        var actNum = solution.minSetSize(arr);

        assertThat(actNum, is(expNum));
    }

}
