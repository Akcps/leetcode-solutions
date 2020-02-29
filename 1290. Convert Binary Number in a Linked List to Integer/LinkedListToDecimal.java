/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
 * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.add(current.val);
            current = current.next;
        }
        int sum = 0;
        int size = stack.size();
        int multiplier = 1;
        for (int i = 0; i < size; i++) {
            int num = stack.pop();
            sum += num * multiplier;
            multiplier *= 2;
        }
        return sum;
    }
}