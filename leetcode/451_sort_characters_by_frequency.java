class Solution {
    // bucket sort - O(n)
    public String frequencySort(String s) {
        List<Character>[] buckets = new List[s.length()];
        int[] count = new int[256];
        for (char c : s.toCharArray())
            count[c]++;
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            if (num == 0) continue;
            if (buckets[num-1] == null) {
                buckets[num-1] = new ArrayList();
            }
            buckets[num-1].add((char)i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length-1; i >= 0; i--) {
            helper(buckets[i], i+1, sb);
        }
        return sb.toString();
    }

    private void helper(List<Character> list, int count, StringBuilder sb) {
        if (list == null || count == 0) return;
        for (Character c : list) {
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
    }
}
