package problem236;

import common.TreeNode;

public final class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        final TreeNode right = lowestCommonAncestor(root.right, p, q);

        return (left != null && right != null) ? root : (left != null ? left : right);
    }

}
