package problem86;

import common.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static common.ListNodeCreatorUtil.createListFrom;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PartitionListTest {

    private PartitionList solution = new PartitionList();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {createListFrom(new int[]{1, 4, 3, 2, 5, 2}), 3, createListFrom(new int[]{1, 2, 2, 4, 3, 5})},
                {createListFrom(new int[]{2, 1}), 2, createListFrom(new int[]{1, 2})}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldPartitionList(final ListNode inList, final int x, final ListNode expList) {
        var actList = solution.partition(inList, x);

        assertThat(actList, is(expList));
    }

}
