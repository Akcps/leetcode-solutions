/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 38.8 MB, less than 59.13% of Java online submissions for Reverse Linked List.
 * Time Complexity: O (n)
 * Space Complexity: O (1)
 */

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
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null; // to track the previous node
        ListNode currentNode = head; // points to the current node
        while (currentNode != null) {
            ListNode nextNode = currentNode.next; // points to the next node.
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }
}