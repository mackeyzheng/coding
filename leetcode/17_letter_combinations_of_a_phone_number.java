class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ret;
        backtracking(digits.toCharArray(), 0, new StringBuilder(), ret);
        return ret;
    }

    private String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void backtracking(char[] digits, int pos, StringBuilder sb, List<String> ret) {
        if (pos >= digits.length) {
            ret.add(sb.toString());
            return;
        }
        for (char c : letters[digits[pos] - '2'].toCharArray()) {
            sb.append(c);
            backtracking(digits, pos + 1, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
