package problem160;

import common.ListNode;
import common.ListNodeCreatorUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IntersectionOfTwoLinkedListsTest {

    private IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

    @DataProvider(name = "dp1")
    public static Object[][] testData() {
        return new Object[][]{
                {TestListData.from(
                        new int[]{4, 1},
                        new int[]{5, 6, 1},
                        new int[]{8, 4, 5}
                )},
                {TestListData.from(
                        new int[]{1, 9, 1},
                        new int[]{3},
                        new int[]{2, 4}
                )},
                {TestListData.from(
                        new int[]{2, 6, 4},
                        new int[]{1, 5}
                )},
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindCommonNode(final TestListData testListData) {
        final ListNode found = solution.getIntersectionNode(testListData.listA, testListData.listB);

        assertThat(found, is(testListData.commonNode));
    }



    private static final class TestListData {
        private final ListNode listA;
        private final ListNode listB;
        private final ListNode commonNode;

        private TestListData(final int[] listAHead, final int[] listBHead, final int[] commonTail) {
            commonNode = commonTail == null ? null : ListNodeCreatorUtil.createListFrom(commonTail);
            listA = ListNodeCreatorUtil.createListFrom(listAHead, commonNode);
            listB = ListNodeCreatorUtil.createListFrom(listBHead, commonNode);
        }

        static TestListData from(final int[] listAHead, final int[] listBHead) {
            return from(listAHead, listBHead, null);
        }

        static TestListData from(final int[] listAHead, final int[] listBHead, final int[] commonTail) {
            return new TestListData(listAHead, listBHead, commonTail);
        }
    }

}
