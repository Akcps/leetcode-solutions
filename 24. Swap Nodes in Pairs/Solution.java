/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
 * Memory Usage: 42.5 MB, less than 5.50% of Java online submissions for Swap Nodes in Pairs.
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode remaining = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(remaining);
        return newHead;
    }
}