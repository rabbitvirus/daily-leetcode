package problem1220;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CountVowelsPermutationTest {

    private CountVowelsPermutation solution = new CountVowelsPermutation();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {1, 5},
                {2, 10},
                {5, 68},
                {144, 18208803}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountPermutations(final int n, final int expCnt) {
        var actCnt = solution.countVowelPermutation(n);

        assertThat(actCnt, is(expCnt));
    }

}
