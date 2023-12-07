/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue (min-heap) to store the nodes based on their values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head nodes of all linked lists to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Dummy node to simplify code
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process nodes from the priority queue
        while (!minHeap.isEmpty()) {
            // Get the node with the smallest value
            ListNode minNode = minHeap.poll();

            // Add the node to the result list
            current.next = minNode;
            current = current.next;

            // Move to the next node in the selected list
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next; // Return the merged sorted list
    }
}