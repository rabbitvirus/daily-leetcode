package problem576;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OutOfBoundaryPathsTest {

    private OutOfBoundaryPaths solution = new OutOfBoundaryPaths();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {2, 2, 2, 0, 0, 6},
                {1, 3, 3, 0, 1, 12}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfPaths(final int m, final int n, final int maxMove, final int startRow, final int startCol, final int expCnt) {
        var actCnt = solution.findPaths(m, n, maxMove, startRow, startCol);

        assertThat(actCnt, is(expCnt));
    }

}
