package problem535;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class CodecTest {

    private static final String TEST_LONG_URL_1 = "https://leetcode.com/problems/design-tinyurl";
    private static final String TEST_LONG_URL_2 = "https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021";

    private Codec codec = new Codec();

    @Test
    public void shouldCreateATinyUrl() {
        final String tinyUrl = codec.encode(TEST_LONG_URL_1);

        assertThat(tinyUrl, matchesPattern("http://tinyurl.com/[0-9a-zA-Z]+"));
    }

    @Test
    public void twoURLsShouldNotHaveTheSameTinyUrl() {
        final String tinyUrl1 = codec.encode(TEST_LONG_URL_1);
        final String tinyUrl2 = codec.encode(TEST_LONG_URL_2);

        assertThat(tinyUrl1, is(not(tinyUrl2)));
    }

    @Test
    public void shouldDecodeATinyUrlToLongUrl() {
        final String tinyUrl = codec.encode(TEST_LONG_URL_1);
        final String longUrl = codec.decode(tinyUrl);

        assertThat(longUrl, is(TEST_LONG_URL_1));
    }

    @Test
    public void shouldCreateSameTinyUrlForTheSameLongUrl() {
        final String tinyUrl1 = codec.encode(TEST_LONG_URL_1);
        final String tinyUrl2 = codec.encode(TEST_LONG_URL_1);

        assertThat(tinyUrl1, is(tinyUrl2));
    }

}
