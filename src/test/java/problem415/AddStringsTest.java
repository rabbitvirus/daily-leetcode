package problem415;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddStringsTest {

    private AddStrings solution = new AddStrings();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"11", "123", "134"},
                {"456", "77", "533"},
                {"9", "2", "11"},
                {"0", "0", "0"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldSumTwoNumbers(final String num1, final String num2, final String expSum) {
        var actSum = solution.addStrings(num1, num2);

        assertThat(actSum, is(expSum));
    }
}
