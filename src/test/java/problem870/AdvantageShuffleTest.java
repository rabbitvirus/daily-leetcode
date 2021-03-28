package problem870;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AdvantageShuffleTest {

    private AdvantageShuffle solution = new AdvantageShuffle();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}, new int[]{2, 11, 7, 15}},
                {new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}, new int[]{24, 32, 8, 12}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldReturnAdvantageShuffle(final int[] a, final int[] b, final int[] expPerm) {
        final int[] actPerm = solution.advantageCount(a, b);

        assertThat(actPerm, is(expPerm));
    }

}
