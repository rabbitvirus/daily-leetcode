package problem329;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestIncreasingPathTest {

    private LongestIncreasingPath solution = new LongestIncreasingPath();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}, 4},
                {new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}, 4},
                {new int[][]{{1}}, 1},
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLongestIncreasingPathInMatrix(final int[][] matrix, final int expLen) {
        var actLen = solution.longestIncreasingPath(matrix);

        assertThat(actLen, is(expLen));
    }

}
