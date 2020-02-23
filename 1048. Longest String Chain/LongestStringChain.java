/**
 * Runtime: 12 ms, faster than 98.62% of Java online submissions for Longest String Chain.
 * Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Longest String Chain.
 */
class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<String>[] wordsList = new List[17];
        for (String word: words) {
            int len = word.length();
            if (wordsList[len] == null) {
                wordsList[len] = new ArrayList<>();
            }
            wordsList[len].add(word);
            map.put(word, 1);
        }

        int max = 1;
        for (int len = 1; len < 17; len++) {
            if (wordsList[len] == null) {
                continue;
            }
            for (String word: wordsList[len])  {
                int preLen = len - 1;
                if (wordsList[preLen] == null) {
                    continue;
                }
                for (String preWord: wordsList[preLen]) {
                    if (isPredecessor(preWord, word)) {
                        map.put(word, Math.max(map.get(word),
                                map.get(preWord) + 1));
                        max = Math.max(max, map.get(word));
                    }
                }
            }
        }
        return max;
    }

    private boolean isPredecessor(String word1, String word2) {
        int pointer1 = 0;
        int pointer2 = 0;
        boolean notMatch = false;
        while (pointer1 < word1.length() && pointer2 < word2.length()) {
            if (word1.charAt(pointer1) == word2.charAt(pointer2)) {
                pointer1++;
                pointer2++;
            } else if (notMatch) {
                return false;
            } else {
                notMatch = true;
                pointer2++;
            }
        }
        return true;
    }
}