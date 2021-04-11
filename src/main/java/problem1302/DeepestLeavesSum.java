package problem1302;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class DeepestLeavesSum {

    public int deepestLeavesSum(final TreeNode root) {
        final List<Integer> levelSum = new ArrayList<>();
        dfs(root, levelSum, 0);
        return levelSum.get(levelSum.size() - 1);
    }

    private void dfs(final TreeNode root, final List<Integer> levelSum, final int level) {
        if (levelSum.size() < level + 1)
            levelSum.add(root.val);
        else
            levelSum.set(level, levelSum.get(level) + root.val);

        if (root.left != null)
            dfs(root.left, levelSum, level + 1);

        if (root.right != null)
            dfs(root.right, levelSum, level + 1);
    }

}
