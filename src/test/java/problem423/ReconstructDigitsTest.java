package problem423;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReconstructDigitsTest {

    private ReconstructDigits solution = new ReconstructDigits();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {"owoztneoer", "012"},
                {"fviefuro", "45"}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldReconstructOriginalDigitsFromEnglish(final String enStr, final String expDigits) {
        var actDigits = solution.originalDigits(enStr);

        assertThat(actDigits, is(expDigits));
    }

}
