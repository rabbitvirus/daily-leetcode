package problem637;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class AverageLevelsBinaryTree {

    public List<Double> averageOfLevels(final TreeNode root) {
        if (root == null) return null;

        final List<Double> avgRes = new LinkedList<>();
        final Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        long sum;
        TreeNode curr;

        while (!q.isEmpty()) {
            final int size = q.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                sum += curr.val;

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            avgRes.add((double) sum / size);
        }

        return avgRes;
    }

}
