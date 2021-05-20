package problem102;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BinaryTreeLevelOrderTraversalTest {

    private BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7))),
                        List.of(List.of(3), List.of(9, 20), List.of(15, 7))},

                {new TreeNode(1), List.of(List.of(1))},
                {null, List.of()}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLevelOrderTraversal(final TreeNode root, final List<List<Integer>> expTraversal) {
        var actTraversal = solution.levelOrder(root);

        assertThat(actTraversal, is(expTraversal));
    }
}
