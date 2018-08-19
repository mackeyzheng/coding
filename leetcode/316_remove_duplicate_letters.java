class Solution {
    // use string builder as a stack
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[256];
        boolean[] visited = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (visited[c]) continue;
            visited[c] = true;
            while (sb.length() > 0 && count[sb.charAt(sb.length() - 1)] > 0 && c < sb.charAt(sb.length() - 1)) {
                visited[sb.charAt(sb.length() - 1)] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
