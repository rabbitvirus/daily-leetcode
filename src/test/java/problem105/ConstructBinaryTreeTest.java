package problem105;

import common.TreeNode;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConstructBinaryTreeTest {

    private ConstructBinaryTree solution = new ConstructBinaryTree();

    @Test
    public void shouldBuildTreeFromPreAndInOrderArrays() {
        var tree = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        assertThat(tree, is(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)))));
    }

    @Test
    public void shouldBuildSingleNodeTreeFromPreAndInOrderArrays() {
        var tree = solution.buildTree(new int[]{-1}, new int[]{-1});

        assertThat(tree, is(new TreeNode(-1)));
    }

}
