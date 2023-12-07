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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // Move to the starting point
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // Reverse the sublist from left to right
        ListNode current = pre.next;
        ListNode next = null;
        ListNode prev = null;

        for (int i = 0; i <= right - left; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect the reversed sublist back to the main list
        pre.next.next = current;
        pre.next = prev;

        return dummy.next;
    }
}