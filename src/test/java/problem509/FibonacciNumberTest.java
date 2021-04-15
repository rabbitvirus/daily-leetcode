package problem509;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciNumberTest {

    private FibonacciNumber solution = new FibonacciNumber();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {2, 1},
                {3, 2},
                {4, 3}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindFibonacciNumber(final int n, final int expFibo) {
        var actFibo = solution.fib(n);

        assertThat(actFibo, is(expFibo));
    }

}
