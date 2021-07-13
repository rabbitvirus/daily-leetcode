package problem162;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindPeakElementTest {

    private FindPeakElement solution = new FindPeakElement();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 2, 3, 1}, Set.of(2)},
                {new int[]{1, 2, 1, 3, 5, 6, 4}, Set.of(1, 5)}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAPeak(final int[] arr, final Set<Integer> possiblePeaksIdx) {
        var actIdx = solution.findPeakElement(arr);

        System.out.println(actIdx);

        assertThat(possiblePeaksIdx.contains(actIdx), is(true));
    }

}
