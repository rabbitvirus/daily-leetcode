package problem632;

import common.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class AddOneRowToTreeTest {

    private AddOneRowToTree solution = new AddOneRowToTree();

    @DataProvider(name = "dp1")
    public static Object[][] provideTestData() {
        return new Object[][]{
                {new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(1)),
                        new TreeNode(6,
                                new TreeNode(5),
                                null)),

                        new TreeNode(4,
                                new TreeNode(1,
                                        new TreeNode(2,
                                                new TreeNode(3),
                                                new TreeNode(1)),
                                        null),
                                new TreeNode(1,
                                        null,
                                        new TreeNode(6,
                                                new TreeNode(5),
                                                null))),

                        1, 2},


                {new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(1)),
                        null),

                        new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1,
                                                new TreeNode(3),
                                                null),
                                        new TreeNode(1,
                                                null,
                                                new TreeNode(1))),
                                null),

                        1, 3},
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldAddOneRowToTree(final TreeNode inTree, final TreeNode expTree, final int val, final int depth) {
        final TreeNode actTree = solution.addOneRow(inTree, val, depth);

        assertThat(actTree, is(expTree));
    }
}
