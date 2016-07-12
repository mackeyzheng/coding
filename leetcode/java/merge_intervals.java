/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return ret;

        PriorityQueue<Interval> queue =
            new PriorityQueue<Interval>(intervals.size(),
                new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start - o2.start;
                    }
        });
        queue.addAll(intervals);

        Interval cur = queue.poll();
        ret.add(cur);
        Interval tail = cur;
        int max_end = tail.end;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.start <= max_end) {
                max_end = Math.max(max_end, cur.end);
                tail.end = max_end;
            } else {
                ret.add(cur);
                tail = cur;
                max_end = tail.end;
            }
        }

        return ret;
    }
}
