package problem417;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class PacificAtlanticWaterFlowTest {

    private PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}},
                        new int[][]{{0, 4}, {1, 3}, {1, 4}, {2, 2}, {3, 0}, {3, 1}, {4, 0}}},
                {new int[][]{{2, 1}, {1, 2}},
                        new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindWaterFlow(final int[][] heights, final int[][] expectedFlowArr) {
        final List<List<Integer>> expFlow = Stream.of(expectedFlowArr)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        var actFlow = solution.pacificAtlantic(heights);

        assertThat(actFlow.size(), is(expFlow.size()));
        assertThat(actFlow.containsAll(expFlow), is(true));
    }

}
