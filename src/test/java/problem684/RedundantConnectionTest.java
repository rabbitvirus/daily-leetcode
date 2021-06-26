package problem684;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RedundantConnectionTest {

    private RedundantConnection solution = new RedundantConnection();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 2}, {1, 3}, {2, 3}}, new int[]{2, 3}},
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}, new int[]{1, 4}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindRedundantConnection(final int[][] edges, final int[] expEdge) {
        var actEdge = solution.findRedundantConnection(edges);

        assertThat(actEdge, is(expEdge));
    }

}
