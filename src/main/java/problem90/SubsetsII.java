package problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class SubsetsII {

    private static final int BUFFER_LEN = 21;

    public List<List<Integer>> subsetsWithDup(final int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> resultList = new LinkedList<>();

        backtrackingAdd(resultList, new int[BUFFER_LEN], nums, 0, 0);

        return resultList;
    }

    private void backtrackingAdd(final List<List<Integer>> resultList, final int[] builderList, final int[] nums, final int numPos, int builderPos) {
        final List<Integer> res = new ArrayList<>(builderPos);
        for (int i = 0; i < builderPos; i++)
            res.add(builderList[i]);

        resultList.add(res);

        for (int i = numPos; i < nums.length; i++) {
            if (i > numPos && nums[i] == nums[i - 1])
                continue;

            builderList[builderPos++] = nums[i];
            backtrackingAdd(resultList, builderList, nums, i + 1, builderPos--);
        }
    }

}
