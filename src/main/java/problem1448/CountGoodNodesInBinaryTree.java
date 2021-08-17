package problem1448;

import common.TreeNode;

public final class CountGoodNodesInBinaryTree {

    public int goodNodes(final TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(final TreeNode root, int curMax) {
        if (root == null)
            return 0;

        int levAdd = 0;
        if (root.val >= curMax) {
            curMax = root.val;
            levAdd = 1;
        }

        return levAdd + goodNodes(root.left, curMax) + goodNodes(root.right, curMax);
    }

}
