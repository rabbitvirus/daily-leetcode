package problem341;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static problem341.TestNestedInteger.listInteger;
import static problem341.TestNestedInteger.singleInteger;

public class NestedIteratorTest {

    @Test
    public void shouldRunCase1() {
        var nestedList = List.of(
                listInteger(List.of(singleInteger(1), singleInteger(1))),
                singleInteger(2),
                listInteger(List.of(singleInteger(1), singleInteger(1)))
        );

        var solution = new NestedIterator(nestedList);

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(1));

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(1));

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(2));

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(1));

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(1));

        assertThat(solution.hasNext(), is(false));
    }

    @Test
    public void shouldRunCase2() {
        var nestedList = List.of(
                listInteger(List.of(singleInteger(1),
                        listInteger(List.of(singleInteger(4),
                                listInteger(List.of(singleInteger(6)))))))
        );

        var solution = new NestedIterator(nestedList);

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(1));

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(4));

        assertThat(solution.hasNext(), is(true));
        assertThat(solution.next(), is(6));

        assertThat(solution.hasNext(), is(false));
    }

}
