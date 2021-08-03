package problem90;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SubsetsIITest {

    private SubsetsII solution = new SubsetsII();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 2, 2}, List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2))},
                {new int[]{0}, List.of(List.of(), List.of(0))}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindUniquePowerSet(final int[] arr, final List<List<Integer>> expSet) {
        var actSet = solution.subsetsWithDup(arr);

        assertThat(actSet.size(), is(expSet.size()));
        assertThat(new HashSet<>(actSet), is(new HashSet<>(expSet)));
    }
}
