class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        // record parent
        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs) {
            String root1 = findRoot(map, pair[0]);
            String root2 = findRoot(map, pair[1]);
            if (!root1.equals(root2)) {
                map.put(root1, root2);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            String root1 = findRoot(map, words1[i]);
            String root2 = findRoot(map, words2[i]);
            if (!root1.equals(root2)) {
                return false;
            }
        }

        return true;
    }

    private String findRoot(Map<String, String> map, String s) {
        String root = s;
        while (map.containsKey(root) && map.get(root) != root) {
            root = map.get(root);
        }
        // compress
        String cur = s;
        while (cur != root) {
            String tmp = map.get(cur);
            map.put(cur, root);
            cur = tmp;
        }
        return root;
    }
}
