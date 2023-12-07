class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long result = 0;

        for (int l = 0; l < n; l++) {
            int cnt = 0;

            for (int r = l; r < n; r++) {
                if (nums.get(r) % modulo == k) {
                    cnt++;
                }

                if (cnt % modulo == k) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int modulo = 3;
        int k = 1;

        long result = solution.countInterestingSubarrays(nums, modulo, k);
        System.out.println("Count of interesting subarrays: " + result);
    }
}