package problem1047;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RemoveAdjacentDuplicatesTest {

    private RemoveAdjacentDuplicates solution = new RemoveAdjacentDuplicates();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"abbaca", "ca"},
                {"azxxzy", "ay"},
                {"aaa", "a"},
                {"aaabbb", "ab"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldRemoveAdjacentDuplicates(final String str, final String expRem) {
        var actRem = solution.removeDuplicates(str);

        assertThat(actRem, is(expRem));
    }

}
