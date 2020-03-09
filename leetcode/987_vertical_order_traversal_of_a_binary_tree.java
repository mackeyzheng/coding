/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // sort comparable class
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        traverse(root, 0, 0, positions);

        Collections.sort(positions);

        int prevX = Integer.MIN_VALUE;
        for (Position pos : positions) {
            if (pos.x != prevX) {
                ret.add(new ArrayList<>());
            }
            ret.get(ret.size() - 1).add(pos.val);
            prevX = pos.x;
        }

        return ret;
    }

    private void traverse(TreeNode node, int x, int y, List<Position> positions) {
        if (node == null) {
            return;
        }
        positions.add(new Position(x, y, node.val));
        traverse(node.left, x - 1, y - 1, positions);
        traverse(node.right, x + 1, y - 1, positions);
    }

    class Position implements Comparable<Position> {
        int x;
        int y;
        int val;

        public Position(int _x, int _y, int _val) {
            x = _x;
            y = _y;
            val = _val;
        }

        @Override
        public int compareTo(Position that) {
            if (this.x != that.x) {
                return Integer.compare(this.x, that.x);
            } else if (this.y != that.y) {
                return Integer.compare(that.y, this.y);
            } else {
                return Integer.compare(this.val, that.val);
            }
        }
    }

    // treemap + treemap + priority queue
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverse(root, 0, 0, map);

        for (TreeMap<Integer, PriorityQueue<Integer>> valueMap : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : valueMap.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            ret.add(list);
        }

        return ret;
    }

    private void traverse(TreeNode node, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) {
            return;
        }

        TreeMap<Integer, PriorityQueue<Integer>> valueMap = map.getOrDefault(x, new TreeMap<>(Comparator.reverseOrder()));
        PriorityQueue<Integer> pq = valueMap.getOrDefault(y, new PriorityQueue<>());
        pq.offer(node.val);
        valueMap.putIfAbsent(y, pq);
        map.putIfAbsent(x, valueMap);

        // by description, it should be y - 1
        // here using y + 1 to make inner TreeMap sort reversely
        // another way is using Comparator.reverseOrder()
        traverse(node.left, x - 1, y - 1, map);
        traverse(node.right, x + 1, y - 1, map);
    }
}
