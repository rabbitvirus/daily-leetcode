package problem1642;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FurthestBuildingTest {

    private FurthestBuilding solution = new FurthestBuilding();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1, 4},
                {new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7},
                {new int[]{14, 3, 19, 3}, 17, 0, 3}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindTheFurthestBuildingIndex(final int[] heights, final int bricks, final int ladders, final int expBuilding) {
        var actBuilding = solution.furthestBuilding(heights, bricks, ladders);

        assertThat(actBuilding, is(expBuilding));
    }

}
