class Solution {
    // time: ~O(n!)
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backtracking(n, n, new StringBuilder(), ret);
        return ret;
    }

    private void backtracking(int left, int right, StringBuilder sb, List<String> ret) {
        if (left > right)
            return; // invalid pairing
        if (left == 0 && right == 0) {
            ret.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            backtracking(left - 1, right, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            sb.append(')');
            backtracking(left, right - 1, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
