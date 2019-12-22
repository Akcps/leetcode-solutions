/**
 * Runtime: 4 ms, faster than 70.23% of Java online submissions for Alien Dictionary.
 * Memory Usage: 35.9 MB, less than 97.30% of Java online submissions for Alien Dictionary.
 */
class Solution {

    Map<Character, Set<Character>> graph = new HashMap<>();
    int[] inDegree = new int[26];

    public String alienOrder(String[] words) {
        buildGraph(words);
        return bfs(words);
    }

    private void buildGraph(String[] words){
        for (String word: words) {
            for (char c: word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }


        for (int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            String cur = words[i];
            int len = Math.min(prev.length(), cur.length());
            for (int j = 0; j < len; j++) {
                char out = prev.charAt(j);
                char in = cur.charAt(j);
                if (out != in) {
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        inDegree[(int) in - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String bfs(String[] words) {
        Queue<Character> q = new LinkedList<Character>();
        for (char c: graph.keySet()) {
            if (inDegree[(int) c-'a'] == 0) {
                q.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()) {
            char out = q.poll();
            result.append(out);
            if (graph.get(out) == null)
                continue;
            for (char in: graph.get(out)) {
                inDegree[(int) in - 'a']--;
                if (inDegree[(int) in - 'a'] == 0) {
                    q.add(in);
                }
            }
        }

        return result.length() == graph.size() ? result.toString(): "";
    }

}