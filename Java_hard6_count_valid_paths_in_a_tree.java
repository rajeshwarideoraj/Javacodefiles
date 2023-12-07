import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long countPaths(int n, int[][] edges) {
        // Build an adjacency list representation of the tree
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // Initialize the count of valid paths
        long[] count = new long[1];

        // Start DFS from each node
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            dfs(i, i, adjacencyList, visited, count);
        }

        // Return the total count of valid paths
        return count[0];
    }

    private void dfs(int start, int current, List<List<Integer>> adjacencyList, boolean[] visited, long[] count) {
        visited[current] = true;

        // Check if the current node label is prime
        if (isPrime(current)) {
            count[0]++;
        }

        // Explore neighbors
        for (int neighbor : adjacencyList.get(current)) {
            if (!visited[neighbor]) {
                dfs(start, neighbor, adjacencyList, visited, count);
            }
        }

        visited[current] = false;  // Backtrack
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        long result = solution.countPaths(n, edges);
        System.out.println(result);  // Output: 5
    }
}