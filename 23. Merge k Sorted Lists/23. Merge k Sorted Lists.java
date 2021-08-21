/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 4 ms, faster than 78.99% of Java online submissions for Merge k Sorted Lists.
 * Memory Usage: 44.6 MB, less than 21.32% of Java online submissions for Merge k Sorted Lists.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode output = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode l: lists) {
            if (l != null) {
                minHeap.add(l);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode n = minHeap.poll();
            if(n.next != null) {
                minHeap.add(n.next);
            }
            output.next = n;
            output = output.next;
        }
        return dummy.next;
    }
}