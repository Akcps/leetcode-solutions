class Solution {
    public String stringShift(String s, int[][] shift) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            list.add(ch);
        }
        for (int[] sh: shift) {
            if (sh[0] == 0) {
                shiftLeft(list, sh[1]);
            } else {
                shiftRight(list, sh[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void shiftLeft (LinkedList<Character> list, int count) {
        while (count > 0) {
            char c = list.removeFirst();
            list.addLast(c);
            count--;
        }
    }
    private void shiftRight (LinkedList<Character> list, int count) {
        while (count > 0) {
            char c = list.removeLast();
            list.addFirst(c);
            count--;
        }
    }
}