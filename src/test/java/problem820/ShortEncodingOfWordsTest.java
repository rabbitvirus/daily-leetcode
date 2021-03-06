package problem820;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShortEncodingOfWordsTest {

    private ShortEncodingOfWords solution = new ShortEncodingOfWords();

    @DataProvider(name = "dp1")
    public static Object[][] testData() {
        return new Object[][]{
                {new String[]{"time", "me", "bell"}, 10},
                {new String[]{"t"}, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCalcLengthOfShortestValidString(final String[] words, final int expLength) {
        final int calcLen = solution.minimumLengthEncoding(words);

        assertThat(calcLen, is(expLength));
    }

}
