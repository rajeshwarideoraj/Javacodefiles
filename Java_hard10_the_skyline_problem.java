class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] building : buildings) {
            // Use negative height for the start point of the building
            buildingPoints.add(new int[]{building[0], -building[2]});
            // Use positive height for the end point of the building
            buildingPoints.add(new int[]{building[1], building[2]});
        }

        // Sort the building points based on x-coordinate and height
        Collections.sort(buildingPoints, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // Max heap to store the heights of the active buildings
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0); // Initially, ground level is 0

        int prevMaxHeight = 0;

        for (int[] buildingPoint : buildingPoints) {
            if (buildingPoint[1] < 0) {
                // Start point of the building
                maxHeap.offer(-buildingPoint[1]);
            } else {
                // End point of the building
                maxHeap.remove(buildingPoint[1]);
            }

            int currentMaxHeight = maxHeap.peek();

            // If the max height changes, add the current point to the result
            if (prevMaxHeight != currentMaxHeight) {
                result.add(List.of(buildingPoint[0], currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}