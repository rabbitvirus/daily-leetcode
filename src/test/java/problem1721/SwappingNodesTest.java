package problem1721;

import common.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static common.ListNodeCreatorUtil.createListFrom;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SwappingNodesTest {

    private SwappingNodes solution = new SwappingNodes();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {createListFrom(new int[]{1, 2, 3, 4, 5}), 2, createListFrom(new int[]{1, 4, 3, 2, 5})},
                {createListFrom(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5, createListFrom(new int[]{7, 9, 6, 6, 8, 7, 3, 0, 9, 5})},
                {createListFrom(new int[]{1}), 1, createListFrom(new int[]{1})},
                {createListFrom(new int[]{1, 2}), 1, createListFrom(new int[]{2, 1})},
                {createListFrom(new int[]{1, 2, 3}), 2, createListFrom(new int[]{1, 2, 3})}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldSwapNodes(final ListNode inList, final int k, final ListNode expOutList) {
        final ListNode actOutList = solution.swapNodes(inList, k);

        assertThat(actOutList, is(expOutList));
    }

}
