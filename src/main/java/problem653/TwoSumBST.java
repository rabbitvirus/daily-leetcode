package problem653;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class TwoSumBST {

    public boolean findTarget(final TreeNode root, final int k) {
        final List<Integer> sortedNodes = new ArrayList<>();
        dfsInOrder(root, sortedNodes);

        int l = 0;
        int r = sortedNodes.size() - 1;

        while (l < r) {
            var lNode = sortedNodes.get(l);
            var rNode = sortedNodes.get(r);
            var sum = lNode + rNode;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }

    private void dfsInOrder(final TreeNode root, final List<Integer> sortedElements) {
        if (root == null)
            return;
        dfsInOrder(root.left, sortedElements);
        sortedElements.add(root.val);
        dfsInOrder(root.right, sortedElements);
    }

}
