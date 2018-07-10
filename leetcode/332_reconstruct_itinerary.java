class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new ArrayList<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        for (List<String> v : map.values()) {
            Collections.sort(v);
        }
        List<String> res = new ArrayList<>();
        dfs("JFK", map, tickets.length + 1, res);
        return res;
    }

    private boolean dfs(String city, Map<String, List<String>> map, int n, List<String> res) {
        res.add(city);
        if (res.size() == n) {
            return true;
        }
        if (map.containsKey(city)) {
            List<String> nexts = map.get(city);
            for (int i = 0; i < nexts.size(); i++) {
                String next = nexts.remove(i);
                if (dfs(next, map, n, res)) {
                    return true;
                }
                nexts.add(i, next);
            }
        }
        res.remove(res.size()-1);
        return false;
    }
}
