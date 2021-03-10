package problem12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class IntegerToRomanTest {

    private IntegerToRoman solution = new IntegerToRoman();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {3, "III"},
                {4, "IV"},
                {9, "IX"},
                {58, "LVIII"},
                {1994, "MCMXCIV"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldConvertIntegerToRoman(final int integer, final String expRoman) {
        final String actRoman = solution.intToRoman(integer);

        assertThat(actRoman, is(expRoman));
    }

}
