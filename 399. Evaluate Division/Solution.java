/**
 * Runtime: 1 ms, faster than 76.17% of Java online submissions for Evaluate Division.
 * Memory Usage: 34.9 MB, less than 96.08% of Java online submissions for Evaluate Division.
 */
class Solution {
    double ans;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            ans = -1;
            List<String> query = queries.get(i);
            dfs(query.get(0), query.get(1), graph, new HashSet<String>(), 1.0);
            result[i] = ans;
        }
        return result;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<String, List<Edge>>();
        for (int i = 0; i < equations.size(); i++) {
            String vertexA = equations.get(i).get(0);
            String vertexB = equations.get(i).get(1);
            List<Edge> edgesA = graph.getOrDefault(vertexA, new ArrayList<>());
            List<Edge> edgesB = graph.getOrDefault(vertexB, new ArrayList<>());
            edgesA.add(new Edge(vertexB, values[i]));
            edgesB.add(new Edge(vertexA, 1 / values[i]));
            graph.put(vertexA, edgesA);
            graph.put(vertexB, edgesB);
        }
        return graph;
    }

    private void dfs(String start, String end, Map<String, List<Edge>> graph, Set<String> visited, double output) {
        if (visited.contains(start)) {
            return;
        }
        visited.add(start);
        List<Edge> neighbours = graph.get(start);
        if (neighbours == null) {
            return;
        }
        if (start.equals(end)) {
            ans = output;
            return;
        }
        for (Edge edge: neighbours) {
            dfs(edge.vertex, end, graph, visited, output * edge.weight);
        }
    }

    class Edge {
        String vertex;
        double weight;

        public Edge(String vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}