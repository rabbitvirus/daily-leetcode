package problem113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class PathSumII {

    public List<List<Integer>> pathSum(final TreeNode root, final int targetSum) {
        final List<List<Integer>> result = new LinkedList<>();
        dfs(root, result, new LinkedList<>(), targetSum, 0);
        return result;
    }

    private void dfs(final TreeNode root, final List<List<Integer>> resultList, final LinkedList<Integer> ongoingList, final int targetSum, final int sum) {
        if (root == null)
            return;

        final int curSum = sum + root.val;
        ongoingList.addLast(root.val);

        if (root.left == null && root.right == null) {
            if (curSum == targetSum)
                resultList.add(new ArrayList<>(ongoingList));

            ongoingList.removeLast();
            return;
        }

        if (root.left != null)
            dfs(root.left, resultList, ongoingList, targetSum, curSum);

        if (root.right != null)
            dfs(root.right, resultList, ongoingList, targetSum, curSum);

        ongoingList.removeLast();
    }

}
