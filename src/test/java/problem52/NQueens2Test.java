package problem52;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NQueens2Test {

    private NQueens2 solution = new NQueens2();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {4, 2},
                {1, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldReturnNumberOfDistinctSolutions(final int n, final int expNum) {
        var actNum = solution.totalNQueens(n);

        assertThat(actNum, is(expNum));
    }
}
