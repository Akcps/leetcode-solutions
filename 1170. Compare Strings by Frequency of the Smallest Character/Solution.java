/**
 * Runtime: 5 ms, faster than 60.21% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
 * Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
 */
class Solution {
    int largestCount = 0;
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        Map<String, Integer> wordsCountMap = new HashMap<>();
        for (String word: words) {
            wordsCountMap.put(word, getSmallestLetterCount(word));
        }
        Map<Integer, Integer> freqMap = getFreqMap(words, wordsCountMap);
        int[] result = new int[queries.length];
        int i = 0;
        for (String query: queries) {
            int count = getSmallestLetterCount(query);
            result[i] = getSmallerCount(count, freqMap);
            i++;
        }
        return result;
    }

    private Map<Integer, Integer> getFreqMap(String[] words, Map<String, Integer> wordsCountMap) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (String word: words) {
            int count = wordsCountMap.get(word);
            freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
            largestCount = Math.max(largestCount, count);
        }
        return freqMap;
    }

    private int getSmallerCount(int value, Map<Integer, Integer> freqMap) {
        int count = 0;
        for (int i = value + 1;  i <= largestCount; i++) {
            if (freqMap.containsKey(i)) {
                count += freqMap.get(i);
            }
        }
        return count;
    }

    private int getSmallestLetterCount(String str) {
        int[] frequency = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            frequency[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                return frequency[i];
            }
        }
        return -1;
    }
}