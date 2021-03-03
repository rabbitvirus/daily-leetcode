package problem268;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MissingNumberTest {

    private MissingNumber finder = new MissingNumber();

    @DataProvider(name = "dp1")
    public static Object[][] testData() {
        return new Object[][]{
                {new int[]{3, 0, 1}, 2},
                {new int[]{0, 1}, 2},
                {new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8},
                {new int[]{0}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMissingNumber(final int[] nums, final int expectedNum) {
        final int numFound = finder.missingNumber(nums);

        assertThat(numFound, is(expectedNum));
    }

}
