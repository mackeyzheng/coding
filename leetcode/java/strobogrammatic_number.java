class Solution {
    // iterate
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            char left = num.charAt(i);
            char right = num.charAt(j);
            if (!map.containsKey(left) || !map.containsKey(right))
                return false;
            if (map.get(left) != right || map.get(right) != left)
                return false;
            i++;
            j--;
        }
        return true;
    }

    // recursive
    public boolean isStrobogrammatic(String num) {
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        return isStrobogrammatic(num.toCharArray(), 0, num.length() - 1);
    }

    private Map<Character, Character> map = new HashMap<>();
    public boolean isStrobogrammatic(char[] num, int s, int e) {
        if (s > e) return true;
        if (s == e) return num[s] == '0' || num[s] == '1' || num[s] == '8';
        return map.getOrDefault(num[s], ' ') == num[e] && map.getOrDefault(num[e], ' ') == num[s] && isStrobogrammatic(num, s+1, e-1);
    }
}
