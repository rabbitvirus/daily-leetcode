package problem150;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReversePolishNotationTest {

    private ReversePolishNotation solution = new ReversePolishNotation();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"2", "1", "+", "3", "*"}, 9},
                {new String[]{"4", "13", "5", "/", "+"}, 6},
                {new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCalcRPN(final String[] tokens, final int expResult) {
        var actResult = solution.evalRPN(tokens);

        assertThat(actResult, is(expResult));
    }

}
