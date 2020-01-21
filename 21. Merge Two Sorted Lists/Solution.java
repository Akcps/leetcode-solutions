/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 41.5 MB, less than 7.07% of Java online submissions for Merge Two Sorted Lists.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0), tail = output;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null){
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }
        return output.next;
    }
}