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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int remainder = length % k;
        int groupSize = length / k;
        curr = head;
        for (int i = 0; i < k; ++i) {
            ListNode newHead = new ListNode(0), write = newHead;
            for (int j = 0; j < groupSize + (i < remainder ? 1 : 0); ++j) {
                write = write.next = new ListNode(curr.val);
                if (curr != null) {
                    curr = curr.next;
                }
            }
            listNodes[i] = newHead.next;
        }
        System.out.println(remainder);
        return listNodes;
    }
}