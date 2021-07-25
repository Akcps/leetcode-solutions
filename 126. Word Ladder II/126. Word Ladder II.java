/**
 * Runtime: 7 ms, faster than 83.33% of Java online submissions for Word Ladder II.
 * Memory Usage: 39.2 MB, less than 89.26% of Java online submissions for Word Ladder II.
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> parents = new HashMap<>();
        for (String w : words) {
            parents.put(w, new ArrayList<>());
        }

        Map<String, Integer> distance = new HashMap<>(); // distance from one word to beginWord
        distance.put(beginWord, 0);

        boolean found = bfs(beginWord, endWord, words, distance, parents);

        if (found) { // if endWord has been found
            dfs(endWord, beginWord, endWord, parents, res, new ArrayList<>());
        }

        return res;

    } // end findLadders

    // BFS: build a graph "parents", also updates "distance" during the process.
    private boolean bfs(String beginWord, String endWord, Set<String> words, Map<String, Integer> distance, Map<String, List<String>> parents) {
        boolean found = false;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 0;

        while (!q.isEmpty() && !found) {
            level++;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                String word = q.poll();
                List<String> nexts = getNexts(word, words);
                for (String next : nexts) {
                    if (next.equals(endWord)) {
                        found = true;
                    }
                    if (!distance.containsKey(next)) { // if "next" has not been visited before
                        q.offer(next);
                        distance.put(next, level);
                        parents.get(next).add(word);
                    } else if (distance.get(next) == distance.get(word) + 1) { // if "next" has been visited before, but in current level
                        // No need to add to queue again, because it has been appeared in this level
                        parents.get(next).add(word);
                    } else {
                        // the "next" has appeared before in smaller level, do nothing
                    }
                } // end for
            } // end for
        } // end while

        return found;
    } // end bfs

    private List<String> getNexts(String word, Set<String> words) {
        List<String> nexts = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (chs[i] == c) continue;
                char tmp = chs[i];
                chs[i] = c;
                String newWord = String.valueOf(chs);
                if (words.contains(newWord)) {
                    nexts.add(newWord);
                }
                chs[i] = tmp;
            }
        } // end for
        return nexts;
    } // end getNexts

    // DFS: search paths
    private void dfs(String word, String beginWord, String endWord, Map<String, List<String>> parents, List<List<String>> res, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            res.add(copy);
            return;
        }
        if (word.equals(endWord)) {
            path.add(endWord);
        }
        for (String parent : parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, endWord, parents, res, path);
            path.remove(path.size() - 1);
        }

    }
}