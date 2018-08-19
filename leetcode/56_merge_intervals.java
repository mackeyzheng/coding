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
    // solution3, time: O(nlgn)
    // based on solution2, improved by skiping some interations
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;

        final int N = intervals.size();
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> ret = new ArrayList<>();
        for (int i = 0, j = 0; i < N; i++) {
            if (i == N-1 || starts[i+1] > ends[i]) {
                ret.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }

        return ret;
    }

    // solution2, time: O(nlgn)
    // java arrays.sort is Dual-Pivot Quicksort, O(nlgn)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        Interval cur = new Interval(start[0], end[0]);
        res.add(cur);
        for (int i = 1; i < intervals.size(); i++) {
            if (start[i] > cur.end) {
                cur = new Interval(start[i], end[i]);
                res.add(cur);
            } else {
                cur.end = Math.max(cur.end, end[i]);
            }
        }
        return res;
    }

    // solution1, time: O(nlgn)
    // java list sort - performance similar to merge sort
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        intervals.sort((a, b) -> a.start - b.start);
        int p = 0;
        res.add(intervals.get(0));
        for (int q = 1; q < intervals.size(); q++) {
            if (res.get(p).end < intervals.get(q).start) {
                res.add(intervals.get(q));
                p++;
            } else {
                res.get(p).end = Math.max(res.get(p).end, intervals.get(q).end);
            }
        }
        return res;
    }
}
