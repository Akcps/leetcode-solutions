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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        for (ListNode list: lists) {
            if (list != null)
                minHeap.add(list);
        }

        ListNode resultHead = null, resultTail = null;
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (resultHead == null) {
                resultHead = resultTail = node;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return resultHead;
    }
}