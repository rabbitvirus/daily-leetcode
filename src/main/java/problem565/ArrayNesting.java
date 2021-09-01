package problem565;

public final class ArrayNesting {

    public int arrayNesting(final int[] nums) {
        final int n = nums.length;
        if (n == 1)
            return 1;

        final Integer[] visited = new Integer[n];
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (visited[i] == null)
                maxLen = Math.max(maxLen, dfs(nums, visited, i));

        return maxLen;
    }

    private int dfs(final int[] nums, final Integer[] visited, final int idx) {
        if (visited[idx] != null)
            return visited[idx];

        visited[idx] = 0;
        visited[idx] = dfs(nums, visited, nums[idx]) + 1;
        return visited[idx];
    }

}
