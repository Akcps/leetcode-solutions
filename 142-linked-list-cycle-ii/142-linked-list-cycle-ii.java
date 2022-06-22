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
    public ListNode detectCycle(ListNode head) {
        ListNode match = cycle(head);
        if (match == null) {
            return null;
        }
        ListNode current = head;
        while(current != match) {
            current = current.next;
            match = match.next;
        }
        return current;
    }
    
    public ListNode cycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            if (fast == slow){
                return fast;
            }
        }
        return null;
    }
 }