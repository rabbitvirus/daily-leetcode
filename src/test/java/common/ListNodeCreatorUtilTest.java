package common;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class ListNodeCreatorUtilTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldNotCreateListFromNullArrayOfNums() {
        ListNodeCreatorUtil.createListFrom(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldNotCreateListWithAppendedContentFromNullArrayOfNums() {
        ListNodeCreatorUtil.createListFrom(null, new ListNode(2));
    }

    @Test
    public void shouldCreateListFromArrayOfNums() {
        final int[] nums = {3, 5, 2};
        ListNode l = ListNodeCreatorUtil.createListFrom(nums);

        for (final int num : nums) {
            assertThat(l.val, is(num));
            l = l.next;
        }

        assertThat(l, is(nullValue()));
    }

    @Test
    public void shouldCreateListWithAppendedContentFromArrayOfNums() {
        final int[] nums = {3, 2, 1};
        final ListNode ap = new ListNode(2);
        ap.next = new ListNode(3);

        ListNode l = ListNodeCreatorUtil.createListFrom(nums, ap);

        for (final int num : nums) {
            assertThat(l.val, is(num));
            l = l.next;
        }

        assertThat(l.val, is(2));
        assertThat(l.next.val, is(3));
        assertThat(l.next.next, is(nullValue()));
    }

}