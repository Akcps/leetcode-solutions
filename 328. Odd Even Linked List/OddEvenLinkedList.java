/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
 * Memory Usage: 41.6 MB, less than 5.00% of Java online submissions for Odd Even Linked List.
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode oddStart = null;
        ListNode even = null;
        ListNode evenStart = null;
        ListNode current = head;
        while (current != null) {
            if (oddStart == null) {
                oddStart = current;
                odd = oddStart;
            } else {
                odd.next = current;
                odd = odd.next;
            }
            current = current.next;
            if (current == null) {
                break;
            }
            if (evenStart == null) {
                evenStart = current;
                even = evenStart;
            } else {
                even.next = current;
                even = even.next;
            }
            current = current.next;
        }
        if (oddStart != null && evenStart != null) {
            even.next = null;
            odd.next = evenStart;
        }
        return oddStart;
    }
}