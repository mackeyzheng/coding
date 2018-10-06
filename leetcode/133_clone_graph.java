/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> done = new HashSet<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (done.contains(cur)) {
                continue;
            }
            map.putIfAbsent(cur, new UndirectedGraphNode(cur.label));
            UndirectedGraphNode copy = map.get(cur);
            for (UndirectedGraphNode next : cur.neighbors) {
                map.putIfAbsent(next, new UndirectedGraphNode(next.label));
                copy.neighbors.add(map.get(next));
                queue.offer(next);
            }
            done.add(cur);
        }
        return map.get(node);
    }

    // dfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, map));
        }
        return clone;
    }
}
