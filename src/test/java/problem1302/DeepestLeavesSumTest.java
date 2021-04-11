package problem1302;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeepestLeavesSumTest {

    private DeepestLeavesSum solution = new DeepestLeavesSum();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(7),
                                        null),
                                new TreeNode(5)),
                        new TreeNode(3,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(8)))), 15},

                {new TreeNode(6,
                        new TreeNode(7,
                                new TreeNode(2,
                                        new TreeNode(9),
                                        null),
                                new TreeNode(7,
                                        new TreeNode(1),
                                        new TreeNode(4))),
                        new TreeNode(8,
                                new TreeNode(1),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(5)))), 19}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindDeepestLeavesSum(final TreeNode root, final int expSum) {
        var actSum = solution.deepestLeavesSum(root);

        assertThat(actSum, is(expSum));
    }

}
