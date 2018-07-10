/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    // TreeMap: O(nlgn), treemap to store start points, use ceilingEntry method to locate right interval start point
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        int[] ret = new int[intervals.length];
        for (int i = 0; i < ret.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            ret[i] = entry == null ? -1 : entry.getValue();
        }
        return ret;
    }

    // sort + sweep line: O(nlgn)
    public int[] findRightInterval(Interval[] intervals) {
        // convert to nodes, storing original index
        final int N = intervals.length;
        Node[] nodes = new Node[N*2];
        for (int i = 0; i < N; i++) {
            nodes[2*i] = new Node(i, intervals[i].start, 0);
            nodes[2*i+1] = new Node(i, intervals[i].end, 1);
        }

        // sort by type and value
        Arrays.sort(nodes, (a, b) -> a.value == b.value ? a.type - b.type : b.value - a.value);

        // sweep line
        int[] ret = new int[N];
        int right = -1;
        for (Node node : nodes) {
            if (node.type == 1) {
                // end node
                ret[node.index] = right;
            } else {
                // start node
                right = node.index;
            }
        }
        return ret;
    }

    class Node {
        int index;
        int value;
        int type; // 0: start, 1: end
        Node(int _index, int _value, int _type) {
            index = _index;
            value = _value;
            type = _type;
        }
    }
}
