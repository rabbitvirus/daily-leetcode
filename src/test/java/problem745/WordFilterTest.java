package problem745;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordFilterTest {

    @Test
    public void shouldFindAppleByPrefixAndSuffix() {
        var wordFilter = new WordFilter(new String[]{"apple"});

        var pos = wordFilter.f("a", "e");

        assertThat(pos, is(0));
    }

}
