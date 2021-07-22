/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 2 ms, faster than 77.68% of Java online submissions for Add Two Numbers.
 * Memory Usage: 45.2 MB, less than 78.06% of Java online submissions for Add Two Numbers.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
 * Memory Usage: 39.5 MB, less than 32.73% of Java online submissions for Add Two Numbers.
 */
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(0, null);
        ListNode head = res;
        int carry = 0;
        int remainder = 0;
        while (cur1 != null && cur2 != null) {
            int val = cur1.val + cur2.val + carry;
            carry = val / 10;
            remainder = val % 10;
            ListNode newNode = new ListNode(remainder, null);
            res.next = newNode;
            cur1 = cur1.next;
            cur2 = cur2.next;
            res = res.next;
        }
        if (cur1 != null) {
            while (cur1 != null) {
                int val = cur1.val + carry;
                carry = val / 10;
                remainder = val % 10;
                ListNode newNode = new ListNode(remainder, null);
                res.next = newNode;
                cur1 = cur1.next;
                res = res.next;
            }
        }
        if (cur2 != null) {
            while (cur2 != null) {
                int val = cur2.val + carry;
                carry = val / 10;
                remainder = val % 10;
                ListNode newNode = new ListNode(remainder, null);
                res.next = newNode;
                cur2 = cur2.next;
                res = res.next;
            }
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry, null);
            res.next = newNode;
            res = res.next;
        }
        return head.next;
    }
}