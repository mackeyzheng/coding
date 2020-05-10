class Solution {
    // time: ~O(n!)
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generate(n, n, new StringBuilder(), ret);
        return ret;
    }

    private void generate(int left, int right, StringBuilder sb, List<String> ret) {
        if (left > right) {
            return;
        }

        if (right == 0) {
            ret.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            generate(left - 1, right, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            sb.append(')');
            generate(left, right - 1, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
