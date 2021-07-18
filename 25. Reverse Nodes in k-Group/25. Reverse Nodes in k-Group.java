/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
 * Memory Usage: 39.5 MB, less than 32.41% of Java online submissions for Reverse Nodes in k-Group.
 * Time Complexity: O (n)
 * Space Complexity: O (n/k) -> recursion stack
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (count != k) {
            return head;
        }
        current = head;
        ListNode prev = null, next = null;
        count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
