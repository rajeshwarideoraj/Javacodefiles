class Solution {
    public int removeDuplicates(int[] nums) {
     // Check for edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize a pointer for unique elements
        int uniquePointer = 0;

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, update the pointer and update the array
            if (nums[i] != nums[uniquePointer]) {
                uniquePointer++;
                nums[uniquePointer] = nums[i];
            }
        }

        // Return the number of unique elements
        return uniquePointer + 1;
   
    }
}