package problem583;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DeleteOperationTest {

    private DeleteOperation solution = new DeleteOperation();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"sea", "eat", 2},
                {"leetcode", "etco", 4}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfOperationsToMakeStringsEqual(final String left, final String right, final int expCnt) {
        var actCnt = solution.minDistance(left, right);

        assertThat(actCnt, is(expCnt));
    }
}
