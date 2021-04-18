package problem19;

import common.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static common.ListNodeCreatorUtil.createListFrom;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RemoveNthNodeFromEndTest {

    private RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {createListFrom(new int[]{1, 2, 3, 4, 5}), 2, createListFrom(new int[]{1, 2, 3, 5})},
                {createListFrom(new int[]{1}), 1, null},
                {createListFrom(new int[]{1, 2}), 1, createListFrom(new int[]{1})}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldRemoveNthNodeFromEndOfList(final ListNode list, final int n, final ListNode expList) {
        var actList = solution.removeNthFromEnd(list, n);

        assertThat(actList, is(expList));
    }

}
