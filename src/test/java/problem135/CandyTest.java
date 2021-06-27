package problem135;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CandyTest {

    private Candy solution = new Candy();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{3}, 1},
                {new int[]{1, 0, 2}, 5},
                {new int[]{1, 2, 2}, 4},
                {new int[]{1, 2, 1}, 4},
                {new int[]{1, 3, 4, 5, 2}, 11}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinNumberOfCandiesToDistribute(final int[] ratings, final int expCnt) {
        var actCnt = solution.candy(ratings);

        assertThat(actCnt, is(expCnt));
    }

}
