package problem814;

import common.TreeNode;

public final class BinaryTreePruning {

    public TreeNode pruneTree(final TreeNode root) {
        if (root == null)
            return root;

        boolean hasOne = false;

        if (pruneTree(root.left) == null)
            root.left = null;
        else
            hasOne = true;

        if (pruneTree(root.right) == null)
            root.right = null;
        else
            hasOne = true;

        return hasOne || root.val == 1 ? root : null;
    }

}
