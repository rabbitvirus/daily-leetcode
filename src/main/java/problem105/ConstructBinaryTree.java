package problem105;

import common.TreeNode;

public final class ConstructBinaryTree {

    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        return createFrom(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode createFrom(final int[] preorder, final int[] inorder, final int pIdx, final int left, final int right) {
        if (pIdx >= preorder.length || left > right)
            return null;

        final TreeNode r = new TreeNode(preorder[pIdx]);

        int rPos = left;
        while (inorder[rPos] != preorder[pIdx])
            rPos++;

        r.left = createFrom(preorder, inorder, pIdx + 1, left, rPos - 1);
        r.right = createFrom(preorder, inorder, pIdx + rPos - left + 1, rPos + 1, right);

        return r;
    }

}
