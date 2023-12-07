class Solution {
    public int romanToInt(String s) {
     // Create a mapping of Roman numerals to their corresponding values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        // Iterate through the string from left to right
        for (int i = 0; i < s.length(); i++) {
            // Get the value of the current Roman numeral
            int currentNumeral = romanMap.get(s.charAt(i));

            // Check if we need to subtract the previous numeral
            if (i > 0 && currentNumeral > romanMap.get(s.charAt(i - 1))) {
                result += currentNumeral - 2 * romanMap.get(s.charAt(i - 1));
            } else {
                result += currentNumeral;
            }
        }

        return result;   
    }
}