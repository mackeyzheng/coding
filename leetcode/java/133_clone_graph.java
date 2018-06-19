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
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> done = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        if (node != null) queue.offer(node);
        while (!queue.isEmpty()) {
            // no need to traverse level by level
            //int len = queue.size();
            //for (int i = 0; i < len; i++) {
                UndirectedGraphNode cur = queue.poll();
                if (done.contains(cur)) continue;
                // copy current node
                map.putIfAbsent(cur, new UndirectedGraphNode(cur.label));
                for (UndirectedGraphNode nb : cur.neighbors) {
                    // copy neighbor node
                    map.putIfAbsent(nb, new UndirectedGraphNode(nb.label));
                    // add to current node neighbors
                    map.get(cur).neighbors.add(map.get(nb));
                    // queued neightbor node to visit later
                    queue.offer(nb);
                }
                // done copying current node
                done.add(cur);
            //}
        }
        return map.getOrDefault(node, null);
    }

    // dfs + recursion
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
