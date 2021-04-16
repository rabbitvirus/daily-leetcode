package problem1209;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DuplicatesRemoverTest {

    private DuplicatesRemover solution = new DuplicatesRemover();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][] {
                {"abcd", 2, "abcd"},
                {"deeedbbcccbdaa", 3, "aa"},
                {"pbbcggttciiippooaais", 2, "ps"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldRemoveDuplicates(final String str, final int k, final String expStr) {
        var actStr = solution.removeDuplicates(str, k);

        assertThat(actStr, is(expStr));
    }

}
