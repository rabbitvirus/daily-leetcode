package problem1448;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountGoodNodesInBinaryTreeTest {

    private CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new TreeNode(3,
                        new TreeNode(1,
                                new TreeNode(3),
                                null),
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(5))), 4},

                {new TreeNode(3,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(2)),
                        null), 3}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfGoodNodes(final TreeNode root, final int expCnt) {
        var actCnt = solution.goodNodes(root);

        assertThat(actCnt, is(expCnt));
    }
}
