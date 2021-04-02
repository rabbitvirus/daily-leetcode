package problem234;

import common.ListNode;
import common.ListNodeCreatorUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PalindromeLinkedListTest {

    private PalindromeLinkedList solution = new PalindromeLinkedList();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {ListNodeCreatorUtil.createListFrom(new int[]{1, 2, 2, 1}), true},
                {ListNodeCreatorUtil.createListFrom(new int[]{1, 2}), false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckPalindromeList(final ListNode head, final boolean expIsPalindrome) {
        var actIsPalindrome = solution.isPalindrome(head);

        assertThat(actIsPalindrome, is(expIsPalindrome));
    }
}
