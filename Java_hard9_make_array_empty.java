import java.util.Arrays;

public class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int minIndex = 0;
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortedNums[minIndex]) {
                minIndex++;
            } else {
                operations++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 1, 4, 2, 5};
        System.out.println(solution.countOperationsToEmptyArray(nums)); // Output: 3
    }
}