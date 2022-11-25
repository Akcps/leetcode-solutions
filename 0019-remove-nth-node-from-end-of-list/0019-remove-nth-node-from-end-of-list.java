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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode nth = dummy;
        
        for(int i = 1; i <= n + 1; i++) {
            nth = nth.next;
        }
        
        while(nth != null) {
            cur = cur.next;
            nth = nth.next;
        }
        
        cur.next = cur.next.next;
        
        return dummy.next;
    }
}