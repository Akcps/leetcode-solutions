/**
 * Runtime: 2 ms, faster than 86.31% of Java online submissions for Reverse Words in a String.
 * Memory Usage: 37.8 MB, less than 63.44% of Java online submissions for Reverse Words in a String.
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                int end = i;
                while(i >= 0 && s.charAt(i) != ' '){
                    i--;
                }
                if(sb.length() > 0){
                    sb.append(" ");
                }
                sb.append(s.substring(i + 1, end + 1));
            }
            i--;
        }
        return sb.toString();
    }
}