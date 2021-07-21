package problem838;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PushDominoesTest {

    private PushDominoes solution = new PushDominoes();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"RR.L", "RR.L"},
                {".L.R...LR..L..", "LL.RR.LLRRLL.."},
                {"..R..", "..RRR"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindStateAfterPush(final String initialState, final String expectedState) {
        var actualState = solution.pushDominoes(initialState);

        assertThat(actualState, is(expectedState));
    }
}
