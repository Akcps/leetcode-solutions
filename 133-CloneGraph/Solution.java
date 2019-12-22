/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

/**
 * Runtime: 2 ms, faster than 48.31% of Java online submissions for Clone Graph.
 * Memory Usage: 33.4 MB, less than 97.65% of Java online submissions for Clone Graph.
 */
class Solution {
    Map<Node, Node> map = new HashMap<>();
    Set<Node> visited = new HashSet<>();

    public Node cloneGraph(Node node) {
        dfs(node);
        return map.get(node);
    }

    public void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node polled = q.poll();
            if (!map.containsKey(polled)) {
                Node newNode = new Node(polled.val, new LinkedList<Node>());
                map.put(polled, newNode);
                for (Node n: polled.neighbors) {
                    q.add(n);
                }
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            Node curr = (Node)entry.getKey();
            List<Node> newNbs = new LinkedList();
            for (Node nb : curr.neighbors) {
                newNbs.add(map.get(nb));
            }
            map.get(curr).neighbors = newNbs;
        }
    }

    private Node dfs(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val, new LinkedList<>());
        map.put(node, newNode);
        for (Node n: node.neighbors) {
            map.get(node).neighbors.add(dfs(n));
        }
        return newNode;
    }
}