package problem537;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ComplexNumberMultiplicationTest {

    private ComplexNumberMultiplication solution = new ComplexNumberMultiplication();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"1+1i", "1+1i", "0+2i"},
                {"1+-1i", "1+-1i", "0+-2i"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldMultiplyComplexNumsAsStr(final String num1, final String num2, final String expNum) {
        var actNum = solution.complexNumberMultiply(num1, num2);

        assertThat(actNum, is(expNum));
    }

}
