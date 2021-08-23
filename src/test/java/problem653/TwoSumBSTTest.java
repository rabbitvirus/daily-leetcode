package problem653;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TwoSumBSTTest {

    private TwoSumBST solution = new TwoSumBST();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2),
                                new TreeNode(4)),
                        new TreeNode(6,
                                null,
                                new TreeNode(7))), 9, true},

                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2),
                                new TreeNode(4)),
                        new TreeNode(6,
                                null,
                                new TreeNode(7))), 28, false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfTwoSumIsPossible(final TreeNode root, final int target, final boolean expAnswer) {
        var actAnswer = solution.findTarget(root, target);

        assertThat(actAnswer, is(expAnswer));
    }

}
