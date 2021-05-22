package problem51;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NQueensTest {

    private NQueens solution = new NQueens();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {4, List.of(List.of(".Q..", "...Q", "Q...", "..Q."), List.of("..Q.", "Q...", "...Q", ".Q.."))},
                {1, List.of(List.of("Q"))}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAllConfigurations(final int n, final List<List<String>> expConfigurations) {
        var actConfigurations = solution.solveNQueens(n);

        assertThat(new HashSet<>(actConfigurations), is(new HashSet<>(expConfigurations)));
    }

}
