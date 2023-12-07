class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        // Sort workers based on their efficiency
        Arrays.sort(time, (a, b) -> {
            if (a[0] + a[2] != b[0] + b[2]) {
                return Integer.compare(b[0] + b[2], a[0] + a[2]);
            } else {
                return Integer.compare(a[3], b[3]);
            }
        });

        // Create priority queues for left and right side of the bridge
        PriorityQueue<int[]> leftQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> rightQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int currentTime = 0;
        int boxesLeft = n;
        int[] leftWorkerTimes = new int[k];
        Arrays.fill(leftWorkerTimes, -1);

        while (boxesLeft > 0) {
            // Move workers from right to left
            while (!rightQueue.isEmpty() && rightQueue.peek()[1] <= currentTime) {
                int[] worker = rightQueue.poll();
                int workerIndex = worker[0];
                leftQueue.offer(new int[]{workerIndex, currentTime + time[workerIndex][3]});
            }

            // Move workers from left to right
            while (!leftQueue.isEmpty() && leftQueue.peek()[1] <= currentTime) {
                int[] worker = leftQueue.poll();
                int workerIndex = worker[0];
                leftWorkerTimes[workerIndex] = currentTime;
                rightQueue.offer(new int[]{workerIndex, currentTime + time[workerIndex][2]});
                boxesLeft--;
            }

            // Add waiting workers on the left side to the right queue
            while (!leftQueue.isEmpty() && leftQueue.peek()[1] > currentTime) {
                rightQueue.offer(leftQueue.poll());
            }

            // Move a worker from the right side to the left side if the bridge is free
            if (!rightQueue.isEmpty()) {
                int[] worker = rightQueue.poll();
                int workerIndex = worker[0];
                currentTime = Math.max(currentTime, time[workerIndex][0]);
                leftQueue.offer(new int[]{workerIndex, currentTime + time[workerIndex][1]});
            } else {
                currentTime++;
            }
        }

        // Find the time at which the last worker reaches the left bank
        int lastWorkerTime = 0;
        for (int timeOnLeft : leftWorkerTimes) {
            lastWorkerTime = Math.max(lastWorkerTime, timeOnLeft);
        }

        return lastWorkerTime;
    }
}