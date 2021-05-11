package problem1423;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximumCardsPointsTest {

    private MaximumCardsPoints solution = new MaximumCardsPoints();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 1}, 3, 12},
                {new int[]{2, 2, 2}, 2, 4},
                {new int[]{9, 7, 7, 9, 7, 7, 9}, 7, 55},
                {new int[]{1, 1000, 1}, 1, 1},
                {new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3, 202},
                {new int[]{100, 40, 17, 9, 73, 75}, 3, 248}};
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxScore(final int[] cards, final int k, final int expScore) {
        var actScore = solution.maxScore(cards, k);

        assertThat(actScore, is(expScore));
    }
}
