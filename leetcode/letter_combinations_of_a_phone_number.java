public class Solution {
    public List<String> letterCombinations(String digits) {
        final String[] letters = {"", "", "abc", "def", "ghi", "jkl",
                                    "mno", "pqrs", "tuv", "wxyz"};
        List<String> ret = new ArrayList<String>();
        StringBuilder entry = new StringBuilder();
        dfs(ret, entry, letters, digits, 0);
        return ret;
    }

    private void dfs(List<String> ret, StringBuilder entry,
                    String[] letters, String digits, int pos) {
        if (pos >= digits.length()) {
            ret.add(entry.toString());
            return;
        }
        int cur = digits.charAt(pos) - '0';
        for (char iter : letters[cur].toCharArray()) {
            entry.append(iter);
            dfs(ret, entry, letters, digits, pos + 1);
            entry.deleteCharAt(entry.length() - 1);
        }
    }
}
