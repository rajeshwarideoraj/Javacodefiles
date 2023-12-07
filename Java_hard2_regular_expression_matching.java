class Solution {
    public boolean isMatch(String s, String p) {
       int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Handle patterns with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isMatch("aa", "a")); // false
        System.out.println(solution.isMatch("aa", "a*")); // true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*.")); // false 
    }
}