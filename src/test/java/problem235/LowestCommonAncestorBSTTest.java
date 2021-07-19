package problem235;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class LowestCommonAncestorBSTTest {

    private static final TreeNode TEST_BST = new TreeNode(6,
            new TreeNode(2,
                    new TreeNode(0),
                    new TreeNode(4,
                            new TreeNode(3),
                            new TreeNode(5))),
            new TreeNode(8,
                    new TreeNode(7),
                    new TreeNode(9))
    );

    private LowestCommonAncestorBST solution = new LowestCommonAncestorBST();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {TEST_BST, new TreeNode(2), new TreeNode(8), 6},
                {TEST_BST, new TreeNode(2), new TreeNode(4), 2},
                {new TreeNode(2, new TreeNode(1), null), new TreeNode(2), new TreeNode(1), 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLCAInBST(final TreeNode root, final TreeNode p, final TreeNode q, final int expVal) {
        var actVal = solution.lowestCommonAncestor(root, p, q);

        assertThat(actVal, is(notNullValue()));
        assertThat(actVal.val, is(expVal));
    }

}