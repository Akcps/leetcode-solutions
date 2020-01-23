/**
 * Runtime: 29 ms, faster than 77.38% of Java online submissions for Substring with Concatenation of All Words.
 * Memory Usage: 55.6 MB, less than 7.14% of Java online submissions for Substring with Concatenation of All Words.
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length() == 0 || words.length == 0) return new ArrayList();
        int n = words[0].length();
        int length = words.length * n;
        Map<String, Integer> frequencies = new HashMap();
        for(String word : words) {
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }
        Set<String> wordsSet = frequencies.keySet();
        List<Integer> indices = new ArrayList();
        for(int i = 0; i < n; i++) {
            Map<String, Integer> currentFrequencies = new HashMap();
            int left = i;
            int count = 0;
            for(int right = i + n - 1; right < s.length(); right += n) {
                String rightEndString = s.substring(right - n + 1, right + 1);
                if(wordsSet.contains(rightEndString)) {
                    currentFrequencies.put(rightEndString, currentFrequencies.getOrDefault(rightEndString, 0) + 1);
                    if(frequencies.get(rightEndString) - currentFrequencies.get(rightEndString) >= 0) {
                        count++;
                    }
                }
                if(right - left + 1 == length) {
                    if(count == words.length) {
                        indices.add(left);
                    }
                    String leftEndString = s.substring(left, left + n);
                    if(wordsSet.contains(leftEndString)) {
                        currentFrequencies.put(leftEndString, currentFrequencies.getOrDefault(leftEndString, 0) - 1);
                        if(frequencies.get(leftEndString) - currentFrequencies.get(leftEndString) >= 1) {
                            count--;
                        }
                    }
                    left += n;
                }
            }
        }
        return indices;
    }
}
