public class Solution {
    // solution2
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        dfs(ret, "", s, 0, 0);
        return ret;
    }

    private void dfs(List<String> ret, String entry, String s, int pos, int phase) {
        if (pos == s.length() && phase == 4) {
            ret.add(entry.substring(0, entry.length()-1)); // remove the last "."
            return;
        }

        if (s.length() - pos  > (4 - phase) * 3 ||  // too long left
            s.length() - pos < (4 - phase) * 1)     // too short left
            return;

        int num = 0;
        for (int i = pos; i < pos + 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num <= 255) {
                entry += s.charAt(i);   // note: do not add "." here to entry, otherwise, there will be redundent "."
                dfs(ret, entry + ".", s, i + 1, phase + 1);
            }
            if (num == 0) break;    // no 0 prefix is allowed
        }
    }

    // solution1
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        backtracking(s.toCharArray(), 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void backtracking(char[] array, int pos, List<Integer> entry, List<String> ret) {
        // terminal condition
        if (pos >= array.length) {
            if (entry.size() == 4) {
                ret.add(build(entry));
            }
            return;
        }

        // pruning: left is too long or too short
        if (array.length - pos > (4 - entry.size()) * 3 ||
            array.length - pos < (4 - entry.size()) * 1) return;

        if (array[pos] == '0') {
            entry.add(0);
            backtracking(array, pos+1, entry, ret);
            entry.remove(entry.size()-1);
        } else {
            int num = 0;
            for (int i = pos; i < array.length; i++) {
                num = num * 10 + (array[i] - '0');
                if (num > 255)
                    break;
                entry.add(num);
                backtracking(array, i + 1, entry, ret);
                entry.remove(entry.size() - 1);
            }
        }
    }

    private String build(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer e : list) {
            sb.append(e).append('.');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
