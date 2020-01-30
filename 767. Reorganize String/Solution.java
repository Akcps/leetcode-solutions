/**
 * Runtime: 3 ms, faster than 65.12% of Java online submissions for Reorganize String.
 * Memory Usage: 38.1 MB, less than 7.14% of Java online submissions for Reorganize String.
 */
class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<CharCount> maxHeap = new PriorityQueue<CharCount>((a,b) -> a.count == b.count ? a.ch - b.ch: b.count - a.count);
        for (char key: charMap.keySet()) {
            if (charMap.getOrDefault(key ,0) > (s.length() + 1) / 2) {
                return "";
            }
            maxHeap.add(new CharCount(key, charMap.get(key)));
        }
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() >= 2) {
            CharCount c1 = maxHeap.poll();
            CharCount c2 = maxHeap.poll();
            result.append(c1.ch);
            result.append(c2.ch);
            c1.count--;
            c2.count--;
            if (c1.count > 0) {
                maxHeap.add(c1);
            }
            if (c2.count > 0) {
                maxHeap.add(c2);
            }
        }
        if (maxHeap.size() > 0) {
            result.append(maxHeap.poll().ch);
        }
        return result.toString();
    }

    class CharCount {
        int count;
        char ch;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}