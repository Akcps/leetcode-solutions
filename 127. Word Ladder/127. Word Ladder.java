/**
 * Runtime: 56 ms, faster than 75.12% of Java online submissions for Word Ladder.
 * Memory Usage: 40.4 MB, less than 79.92% of Java online submissions for Word Ladder.
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord))
            return 0;

        int level = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String currentWord = q.poll();
                if (currentWord.equals(endWord))
                    return level + 1;
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] ch = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[j] = c;
                        String transformedWord = new String(ch);
                        if (words.contains(transformedWord) && !transformedWord.equals(currentWord)) {
                            q.add(transformedWord);
                            words.remove(transformedWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}