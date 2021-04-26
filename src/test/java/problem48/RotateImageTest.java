package problem48;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RotateImageTest {

    private RotateImage solution = new RotateImage();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}},
                {new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}, new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}}},
                {new int[][]{{1}}, new int[][]{{1}}},
                {new int[][]{{1, 2}, {3, 4}}, new int[][]{{3, 1}, {4, 2}}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldRotateImage(final int[][] inArr, final int[][] expArr) {
        solution.rotate(inArr);

        assertThat(inArr, is(expArr));
    }

}
