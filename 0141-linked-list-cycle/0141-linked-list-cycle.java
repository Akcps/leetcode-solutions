/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head, second = head;
        while (second != null) {
            second = second.next;
            if (second == null) {
                return false;
            }
            first = first.next;
            second = second.next;
            
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}