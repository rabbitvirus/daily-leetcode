package problem92;

import common.ListNode;
import common.ListNodeCreatorUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReverseLinkedListTest {

    private ReverseLinkedList solution = new ReverseLinkedList();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {ListNodeCreatorUtil.createListFrom(new int[]{1, 2, 3, 4, 5}), 2, 4, ListNodeCreatorUtil.createListFrom(new int[]{1, 4, 3, 2, 5})},
                {ListNodeCreatorUtil.createListFrom(new int[]{5}), 1, 1, ListNodeCreatorUtil.createListFrom(new int[]{5})},
                {ListNodeCreatorUtil.createListFrom(new int[]{3, 5}), 1, 2, ListNodeCreatorUtil.createListFrom(new int[]{5, 3})}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldReverseLinkedListRanged(final ListNode head, final int from, final int to, final ListNode expList) {
        var actList = solution.reverseBetween(head, from, to);

        assertThat(actList, is(expList));
    }

}
