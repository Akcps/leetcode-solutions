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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val-b.val);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (ListNode l: lists) {
            if (l != null) {
              heap.add(l);  
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            System.out.println(tmp.val);
            cur.next = tmp;
            tmp = tmp.next;
            if (tmp != null) {
                heap.add(tmp);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}