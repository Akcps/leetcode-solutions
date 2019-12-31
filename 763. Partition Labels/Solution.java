/**
 * Runtime: 3 ms, faster than 87.64% of Java online submissions for Partition Labels.
 * Memory Usage: 35.9 MB, less than 96.10% of Java online submissions for Partition Labels.
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];

        for(int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        List<Integer> partition = new ArrayList<>();
        for (int i = 0 ; i < S.length(); i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i==j) {
                partition.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return partition;
    }
}