package problem791;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.Is.is;

public class CustomSortStringTest {

    @Test
    public void shouldPerformCustomSort() {
        var solution = new CustomSortString();

        var res = solution.customSortString("cba", "abcd");

        assertThat(res, anyOf(is("cbad"), is("dcba"), is("cdba"), is("cbda")));
    }

}
