package problem1339;

import common.TreeNode;

public final class MaximumProductOfSplittedBinaryTree {

    private static final long MOD = 1_000_000_007;

    private long maxProduct = Long.MIN_VALUE;

    public int maxProduct(final TreeNode root) {
        final long totalSum = sum(root);
        product(root, totalSum);
        return (int) (maxProduct % MOD);
    }

    private long sum(final TreeNode root) {
        if (root == null)
            return 0L;

        return root.val + sum(root.left) + sum(root.right);
    }

    private long product(final TreeNode root, final long totalSum) {
        if (root == null)
            return 0L;

        final long sum = root.val + product(root.left, totalSum) + product(root.right, totalSum);
        maxProduct = Math.max(maxProduct, sum * (totalSum - sum));
        return sum;
    }

}
