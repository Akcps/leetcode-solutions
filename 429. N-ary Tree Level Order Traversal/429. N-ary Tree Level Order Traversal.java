/**
 * Runtime: 2 ms, faster than 86.64% of Java online submissions for N-ary Tree Level Order Traversal.
 * Memory Usage: 39.6 MB, less than 94.97% of Java online submissions for N-ary Tree Level Order Traversal.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelValues;
        while (!queue.isEmpty()) {
            int len = queue.size();
            levelValues = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                levelValues.add(node.val);
                for (Node n: node.children) {
                    queue.add(n);
                }
            }
            result.add(levelValues);
        }

        return result;
    }
}