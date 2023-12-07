class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        // First row
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);

            // First element in each row is always 1
            row.add(1);

            // Calculate the rest of the elements in the row
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element in each row is always 1
            row.add(1);

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);

        for (List<Integer> row : result) {
            System.out.println(row);
        } 
    }
}