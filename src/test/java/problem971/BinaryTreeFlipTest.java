package problem971;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BinaryTreeFlipTest {

    private BinaryTreeFlip solution = new BinaryTreeFlip();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new TreeNode(1, new TreeNode(2), null), new int[]{2, 1}, List.of(-1)},
                {new TreeNode(1, new TreeNode(2), new TreeNode(3)), new int[]{1, 3, 2}, List.of(1)},
                {new TreeNode(1, new TreeNode(2), new TreeNode(3)), new int[]{1, 2, 3}, Collections.emptyList()}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFlipTreeToMatchVoyage(final TreeNode root, final int[] voyage, final List<Integer> expFlip) {
        var actFlip = solution.flipMatchVoyage(root, voyage);

        assertThat(actFlip, is(expFlip));
    }
}
