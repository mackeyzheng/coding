class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return ret;
        }
        dfs(num, 0, target, 0, 0, new StringBuilder(), ret);
        return ret;
    }

    private void dfs(String num, int pos, int target, long eval, long multiply, StringBuilder sb, List<String> ret) {
        if (pos >= num.length()) {
            if (target == eval) {
                ret.add(sb.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // invalid number start with 0, like 0123
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }
            int len = sb.length();
            long number = Long.parseLong(num.substring(pos, i + 1)); // use long here to avoid integer overflow
            // first number (no operator at previous position)
            if (pos == 0) {
                sb.append(number);
                dfs(num, i + 1, target, number, number, sb, ret);
                sb.setLength(len);
                continue;
            }

            // has previous number
            // +
            sb.append('+');
            sb.append(number);
            dfs(num, i + 1, target, eval + number, number, sb, ret);
            sb.setLength(len);

            // -
            sb.append('-');
            sb.append(number);
            dfs(num, i + 1, target, eval - number, -number, sb, ret);
            sb.setLength(len);

            // *
            sb.append('*');
            sb.append(number);
            dfs(num, i + 1, target, eval - multiply + multiply * number, multiply * number, sb, ret); // hard point
            sb.setLength(len);
        }
    }
}
