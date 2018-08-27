class Solution {
    // dfs
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        List<Double> ret = new ArrayList<>();
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equ = equations[i];
            map.putIfAbsent(equ[0], new HashMap<>());
            map.get(equ[0]).put(equ[1], values[i]);
            map.putIfAbsent(equ[1], new HashMap<>());
            map.get(equ[1]).put(equ[0], 1 / values[i]);
        }
        for (String[] query : queries) {
            if (!map.containsKey(query[0]) || !map.containsKey(query[1])) {
                ret.add(-1.0);
            } else if (query[0].equals(query[1])) {
                ret.add(1.0);
            } else {
                int size = ret.size();
                dfs(query[0], query[1], map, 1.0, new HashSet<>(), ret, size);
                if (size == ret.size())
                    ret.add(-1.0); // not found
            }
        }
        double[] array = new double[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }

    private void dfs(String cur, String target, Map<String, Map<String, Double>> map, double result,
            Set<String> visited, List<Double> ret, int originalSize) {
        if (ret.size() > originalSize)
            return; // already found
        if (cur.equals(target)) {
            ret.add(result);
            return;
        }
        for (Map.Entry<String, Double> entry : map.get(cur).entrySet()) {
            String next = entry.getKey();
            if (visited.contains(next))
                continue;
            visited.add(next);
            dfs(next, target, map, result * entry.getValue(), visited, ret, originalSize);
            visited.remove(next);
            if (ret.size() > originalSize)
                return; // already found
        }
    }
}
