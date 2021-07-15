package problem611;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ValidTriangleNumberTest {

    private ValidTriangleNumber solution = new ValidTriangleNumber();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{2, 2, 3, 4}, 3},
                {new int[]{4, 2, 3, 4}, 4}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfValidTriangles(final int[] nums, final int expCnt) {
        var actCnt = solution.triangleNumber(nums);

        assertThat(actCnt, is(expCnt));
    }

}
