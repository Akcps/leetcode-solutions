class Solution {
    
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {
        return numDecoding(s, 0);
    }
    
    private int numDecoding(String s, int start) {
        
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        if (start == s.length()) {
            return 1;
        }
        
        if (s.charAt(start) == '0') {
                return 0;
        }
        
        if (start == s.length() - 1) {
            return 1;
        }
        
        int count = numDecoding(s, start + 1);
        if (start + 1 < s.length()) {
            Integer val = Integer.valueOf(s.substring(start, start + 2));
            if (val <= 26) {
                count += numDecoding(s, start + 2);
            }
        }
        
        memo.put(start, count);
        
        return count;
    }
}