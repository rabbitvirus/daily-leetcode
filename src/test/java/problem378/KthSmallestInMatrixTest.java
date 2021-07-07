package problem378;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class KthSmallestInMatrixTest {

    private KthSmallestInMatrix solution = new KthSmallestInMatrix();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8, 13},
                {new int[][]{{-5}}, 1, -5},
                {new int[][]{{1, 2}, {1, 3}}, 2, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindKthSmallestElement(final int[][] matrix, final int k, final int expEl) {
        var actEl = solution.kthSmallest(matrix, k);

        assertThat(actEl, is(expEl));
    }

}
