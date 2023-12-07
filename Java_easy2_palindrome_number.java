class Solution {
    public boolean isPalindrome(int x) {
        // Convert the integer to a string
        String str = String.valueOf(x);
        
        // Use two pointers to compare characters from the beginning and end of the string
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            // If characters don't match, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            
            // Move the pointers towards each other
            left++;
            right--;
        }
        
        // If the loop completes, it means the integer is a palindrome
        return true;
    }
}