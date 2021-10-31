/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
 * Memory Usage: 36.8 MB, less than 94.66% of Java online submissions for Flatten a Multilevel Doubly Linked List.
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node start = new Node(0, null, head, null);
        Node current = start;
        Node prev = start;
        stack.add(head);
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (prev != null) {
                prev.next = current;
            }
            if (prev != null) {
                current.prev = prev;
            }

            if (current.next != null) {
                stack.add(current.next);
            }
            if (current.child != null) {
                stack.add(current.child);
                current.child = null;
            }
            prev = current;
        }
        start.next.prev = null;
        return start.next;
    }

}