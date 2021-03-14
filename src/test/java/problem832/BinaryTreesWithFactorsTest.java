package problem832;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BinaryTreesWithFactorsTest {

    private BinaryTreesWithFactors solution = new BinaryTreesWithFactors();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[]{2, 4}, 3},
                {new int[]{2, 4, 5, 10}, 7}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfFactoredBinaryTrees(final int[] inArr, final int expNum) {
        final int actNum = solution.numFactoredBinaryTrees(inArr);

        assertThat(actNum, is(expNum));
    }
}
