package problem105;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public final class ConstructBinaryTree {

    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        final Map<Integer, Integer> inLookup = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inLookup.put(inorder[i], i);

        return createFrom(inLookup, preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode createFrom(final Map<Integer, Integer> inLookup, final int[] preorder, final int[] inorder, final int pIdx, final int left, final int right) {
        if (pIdx >= preorder.length || left > right)
            return null;

        final TreeNode r = new TreeNode(preorder[pIdx]);
        final int rPos = inLookup.get(preorder[pIdx]);

        r.left = createFrom(inLookup, preorder, inorder, pIdx + 1, left, rPos - 1);
        r.right = createFrom(inLookup, preorder, inorder, pIdx + rPos - left + 1, rPos + 1, right);

        return r;
    }

}
