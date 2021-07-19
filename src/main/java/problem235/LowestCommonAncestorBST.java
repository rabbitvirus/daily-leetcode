package problem235;

import common.TreeNode;

public final class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null)
            return null;

        final int val = root.val;
        if (val == p.val || val == q.val)
            return root;

        if ((p.val < val && val < q.val) || (p.val > val && val > q.val))
            return root;

        return lowestCommonAncestor(p.val > val ? root.right : root.left, p, q);
    }

}
