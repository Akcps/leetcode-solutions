/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
 * Memory Usage: 41.1 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
 */
class Solution {
    Map<Node, Node> visited = new HashMap<Node,Node>();

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        if (visited.containsKey(head))
            return visited.get(head);

        Node n = new Node(head.val, null, null);

        visited.put(head, n);

        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);

        return n;
    }
}