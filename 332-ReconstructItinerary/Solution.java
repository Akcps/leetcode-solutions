/**
 * Runtime: 5 ms, faster than 80.48% of Java online submissions for Reconstruct Itinerary.
 * Memory Usage: 43.6 MB, less than 64.18% of Java online submissions for Reconstruct Itinerary.
 */
class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> ticket: tickets) {
            PriorityQueue<String> cities = graph.getOrDefault(ticket.get(0), new PriorityQueue<String>());
            cities.add(ticket.get(1));
            graph.put(ticket.get(0), cities);
        }

        List<String> result = new LinkedList<String>();
        dfs("JFK", result);
        return result;
    }

    private void dfs(String city, List<String> result) {
        PriorityQueue<String> cities = graph.get(city);
        while(cities != null && !cities.isEmpty()) {
            dfs(cities.poll(), result);
        }
        result.add(0, city);
    }
}