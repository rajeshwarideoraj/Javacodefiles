class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check for digits
            if (Character.isDigit(c)) {
                seenDigit = true;
            }
            // Check for '+' or '-'
            else if (c == '+' || c == '-') {
                // Must be the first character or must be after 'e' or 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            // Check for dot '.'
            else if (c == '.') {
                // Must not have seen dot before and must not have seen 'e' or 'E'
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            }
            // Check for 'e' or 'E'
            else if (c == 'e' || c == 'E') {
                // Must not have seen 'e' or 'E' before, and there must be at least one digit before 'e' or 'E'
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false; // Reset seenDigit for the digits after 'e' or 'E'
            }
            // Any other character is invalid
            else {
                return false;
            }
        }

        // The number must end with a digit
        return seenDigit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases
        System.out.println(solution.isNumber("2"));        // true
        System.out.println(solution.isNumber("0089"));     // true
        System.out.println(solution.isNumber("-0.1"));      // true
        System.out.println(solution.isNumber("+3.14"));     // true
        System.out.println(solution.isNumber("4."));        // true
        System.out.println(solution.isNumber("-.9"));       // true
        System.out.println(solution.isNumber("2e10"));      // true
        System.out.println(solution.isNumber("-90E3"));     // true
        System.out.println(solution.isNumber("3e+7"));      // true
        System.out.println(solution.isNumber("+6e-1"));     // true
        System.out.println(solution.isNumber("53.5e93"));   // true
        System.out.println(solution.isNumber("-123.456e789"));  // true

        System.out.println(solution.isNumber("abc"));      // false
        System.out.println(solution.isNumber("1a"));       // false
        System.out.println(solution.isNumber("1e"));       // false
        System.out.println(solution.isNumber("e3"));       // false
        System.out.println(solution.isNumber("99e2.5"));   // false
        System.out.println(solution.isNumber("--6"));      // false
        System.out.println(solution.isNumber("-+3"));      // false
        System.out.println(solution.isNumber("95a54e53")); // false
    }
}