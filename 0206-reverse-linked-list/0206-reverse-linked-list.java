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
    ListNode dummy;
    ListNode cur;
    public ListNode reverseList(ListNode head) {
        dummy = new ListNode();
        cur = dummy;
        reverse(head);
        return dummy.next;
    }
    
    private void reverse(ListNode node) {
        if (node == null) {
            return;
        }
        if (node != null) {
            reverse(node.next);
        } 
        
        cur.next = node;
        cur = cur.next;
        cur.next = null;
    }
}