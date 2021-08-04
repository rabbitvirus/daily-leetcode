package problem113;


import common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PathSumIITest {

    private PathSumII solution = new PathSumII();

    @Test
    public void shouldFindAllPathsIfTheyExist() {
        var expList = List.of(
                List.of(5, 4, 11, 2),
                List.of(5, 8, 4, 5)
        );

        var root = new TreeNode(
                5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)))
        );

        var actList = solution.pathSum(root, 22);

        assertThat(actList, is(expList));
    }

    @Test
    public void shouldNotFindAnyPathsIfTargetSumCannotBeFound() {
        var root = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        var actList = solution.pathSum(root, 5);

        assertThat(actList, is(List.of()));
    }

}
