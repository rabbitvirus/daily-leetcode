package problem18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public final class FourSum {

    public List<List<Integer>> fourSum(final int[] nums, final int target) {
        Arrays.sort(nums);

        final List<List<Integer>> res = new LinkedList<>();
        sumSubRec(res, nums, target, 0, new int[2], 0);
        return res;
    }

    private void sumSubRec(final List<List<Integer>> res, final int[] nums, final int target, final int from,
                           final int[] buffer, final int bufPos) {
        if (bufPos == 2) {
            int l = from;
            int r = nums.length - 1;
            while (l < r) {
                var sum = buffer[0] + buffer[1] + nums[l] + nums[r];
                if (sum == target) {
                    res.add(List.of(buffer[0], buffer[1], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1])
                        l++;

                    while (l < r && nums[r - 1] == nums[r])
                        r--;

                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        } else {
            final int range = nums.length + bufPos - 3;
            for (int i = from; i < range; i++) {
                if (i > from && nums[i] == nums[i - 1])
                    continue;

                buffer[bufPos] = nums[i];
                sumSubRec(res, nums, target, i + 1, buffer, bufPos + 1);
            }
        }
    }

}
