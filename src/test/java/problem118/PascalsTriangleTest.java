package problem118;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PascalsTriangleTest {

    private PascalsTriangle solution = new PascalsTriangle();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {5, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1))},
                {1, List.of(List.of(1))}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCreatePascalsTriangle(final int n, final List<List<Integer>> expTriangle) {
        var actTriangle = solution.generate(n);

        assertThat(actTriangle, is(expTriangle));
    }

}
