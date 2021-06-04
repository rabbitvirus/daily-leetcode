package problem752;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OpenTheLockTest {

    private OpenTheLock solution = new OpenTheLock();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6},
                {new String[]{"8888"}, "0009", 1},
                {new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888", -1},
                {new String[]{"0000"}, "8888", -1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinNumberOfMovesToOpenTheLock(final String[] deadends, final String target, final int expNo) {
        var actNo = solution.openLock(deadends, target);

        assertThat(actNo, is(expNo));
    }

}
