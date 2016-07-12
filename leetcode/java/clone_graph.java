/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(cur).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode new_node = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, new_node);
                    map.get(cur).neighbors.add(new_node);
                    queue.offer(neighbor);
                }
            }
        }

        return map.get(node);
    }

//    // use Set<Integer> to avoid loops
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null) return null;
//        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
//        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
//        Set<Integer> done = new HashSet<Integer>();
//
//        queue.offer(node);
//        while (!queue.isEmpty()) {
//            UndirectedGraphNode cur = queue.poll();
//            done.add(cur.label);
//
//            UndirectedGraphNode new_cur = map.get(cur.label);
//            if (new_cur == null) {
//                new_cur = new UndirectedGraphNode(cur.label);
//                map.put(cur.label, new_cur);
//            }
//
//            for (UndirectedGraphNode neighbor : cur.neighbors) {
//                // clone cur's neighbors to new_cur
//                UndirectedGraphNode new_node = map.get(neighbor.label);
//                if (new_node == null) {
//                    new_node = new UndirectedGraphNode(neighbor.label);
//                    map.put(neighbor.label, new_node);
//                }
//                new_cur.neighbors.add(new_node);
//
//                // put cur's neighbors to queue
//                if (!done.contains(neighbor.label) && !queue.contains(neighbor)) {
//                    queue.offer(neighbor);
//                }
//            }
//        }
//
//        return map.get(node.label);
//    }
}
