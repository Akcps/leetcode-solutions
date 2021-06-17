/**
 * Runtime: 49 ms, faster than 31.41% of Java online submissions for HTML Entity Parser.
 * Memory Usage: 39.9 MB, less than 46.21% of Java online submissions for HTML Entity Parser.
 */
class Solution {
    public String entityParser(String text) {
        Map<String, String> chars = new HashMap<>();
        chars.put("&quot;", "\"");
        chars.put("&apos;", "\'");
        chars.put("&amp;", "&");
        chars.put("&gt;", ">");
        chars.put("&lt;", "<");
        chars.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder(text);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '&') {
                stack.push(i);
            }
        }


        while (!stack.isEmpty()) {
            int start = stack.pop();

            for (int i = start; i < sb.length(); i++) {
                if (text.charAt(i) == ';') {
                    String  str = sb.substring(start, i + 1);
                    String replacement = chars.getOrDefault(str, str);
                    sb.replace(start, i + 1, replacement);
                    break;
                }
            }
        }

        return sb.toString();
    }
}