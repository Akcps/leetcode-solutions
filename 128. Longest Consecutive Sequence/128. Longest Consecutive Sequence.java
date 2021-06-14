class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int nextNum = num + 1;
                int currentStreak = 1;
                while (set.contains(nextNum)) {
                    currentStreak++;
                    nextNum++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}