package problem236;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class LowestCommonAncestorTest {

    private static final TreeNode TEST_TREE = new TreeNode(3,
            new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(2,
                            new TreeNode(7),
                            new TreeNode(4))),
            new TreeNode(1,
                    new TreeNode(0),
                    new TreeNode(8))
    );

    private static final TreeNode SIMPLE_TEST_TREE = new TreeNode(1, null, new TreeNode(2));

    private LowestCommonAncestor solution = new LowestCommonAncestor();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {TEST_TREE, new TreeNode(5), new TreeNode(1), 3},
                {TEST_TREE, new TreeNode(5), new TreeNode(4), 5},
                {SIMPLE_TEST_TREE, new TreeNode(1), new TreeNode(2), 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q, final int expNodeVal) {
        var actNodeVal = solution.lowestCommonAncestor(root, p, q);

        assertThat(actNodeVal, is(notNullValue()));
        assertThat(actNodeVal.val, is(expNodeVal));
    }
}
