package problem658;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KClosestElementsTest {

    private KClosestElements solution = new KClosestElements();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 4, 3, List.of(1, 2, 3, 4)},
                {new int[]{1, 2, 3, 4, 5}, 4, -1, List.of(1, 2, 3, 4)}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindKClosestElements(final int[] arr, final int k, final int x, final List<Integer> expList) {
        var actList = solution.findClosestElements(arr, k, x);

        assertThat(actList, is(expList));
    }

}
