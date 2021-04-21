package problem120;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleTest {

    private Triangle solution = new Triangle();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)), 11},
                {List.of(List.of(-10)), -10}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMin(final List<List<Integer>> triangle, final int expOut) {
        var actOut = solution.minimumTotal(triangle);

        assertThat(actOut, is(expOut));
    }
}
