package problem637;

import common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AverageLevelsBinaryTreeTest {

    private AverageLevelsBinaryTree solution = new AverageLevelsBinaryTree();

    @Test
    public void shouldCalcAveragePerLevel() {
        final TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        final List<Double> avgList = solution.averageOfLevels(root);

        assertThat(avgList, is(List.of(3d, 14.5d, 11d)));
    }

}