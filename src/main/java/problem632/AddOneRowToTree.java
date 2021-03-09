package problem632;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public final class AddOneRowToTree {

    public TreeNode addOneRow(final TreeNode root, final int v, final int d) {
        if (d == 1)
            return replaceNullRoot(root, v);

        final Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int qSize;
        TreeNode ptr, nn;

        for (int i = 1; i < d - 1; i++) {
            qSize = q.size();
            while (qSize-- > 0) {
                ptr = q.poll();
                if (ptr.left != null) q.offer(ptr.left);
                if (ptr.right != null) q.offer(ptr.right);
            }
        }

        while (!q.isEmpty()) {
            nn = new TreeNode(v);
            ptr = q.poll();
            nn.left = ptr.left;
            ptr.left = nn;

            nn = new TreeNode(v);
            nn.right = ptr.right;
            ptr.right = nn;
        }

        return root;
    }

    private TreeNode replaceNullRoot(final TreeNode root, final int v) {
        final TreeNode newRoot = new TreeNode(v);
        newRoot.left = root;
        return newRoot;
    }
}
