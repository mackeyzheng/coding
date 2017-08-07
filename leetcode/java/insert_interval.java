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
    // solution 1
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        for (Interval cur : intervals) {
            if (newInterval == null || cur.end < newInterval.start) {
                ret.add(cur);
                continue;
            }
            if (cur.start > newInterval.end) {
                ret.add(newInterval);
                ret.add(cur);
                newInterval = null;
                continue;
            }
            merge(cur, newInterval);
        }
        if (newInterval != null) ret.add(newInterval);
        return ret;
    }

    private void merge(Interval a, Interval b) {
        b.start = Math.min(a.start, b.start);
        b.end = Math.max(a.end, b.end);
    }

    // solution 2
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval cur : intervals) {
            if (newInterval.start > cur.end) {
                res.add(cur);
            } else if (cur.start > newInterval.end) {
                res.add(newInterval);
                newInterval = cur;
            } else if (cur.end >= newInterval.start || newInterval.end >= cur.start) {
                newInterval = new Interval(Math.min(cur.start, newInterval.start), Math.max(cur.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }
}
