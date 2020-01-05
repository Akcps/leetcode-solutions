/**
 * Runtime: 30 ms, faster than 25.00% of Java online submissions for Get Watched Videos by Your Friends.
 * Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for Get Watched Videos by Your Friends.
 */
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer> levelFriends = bfs(friends, id, level);
        Map<String, Integer> countFreq = new HashMap<String, Integer>();
        for (int index: levelFriends) {
            for (String friend: watchedVideos.get(index)) {
                countFreq.put(friend, countFreq.getOrDefault(friend, 0) + 1);
            }
        }
        Queue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(
                        (a, b)->a.getValue() == b.getValue() ?
                                a.getKey().compareTo(b.getKey()) :
                                a.getValue() - b.getValue());
        minHeap.addAll(countFreq.entrySet());
        List<String> res = new ArrayList<>();
        while(!minHeap.isEmpty())
            res.add(minHeap.poll().getKey());
        return res;
    }

    private List<Integer> bfs (int[][] friends, int id, int targetLevel) {
        Set<Integer> visited = new HashSet<Integer>();
        int level = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(id);
        visited.add(id);
        List<Integer> levelFriends = new LinkedList<Integer>();
        while (!queue.isEmpty() && level <= targetLevel) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int polled = queue.poll();
                if (level == targetLevel) {
                    levelFriends.add(polled);
                }
                for (int friend: friends[polled]) {
                    if (!visited.contains(friend)) {
                        queue.add(friend);
                        visited.add(friend);
                    }
                }
            }
            level++;
        }
        return levelFriends;
    }
}