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
    // solution 2
    // first, count the max number of intervals that are not overlaped
    // then, use length - count
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int count = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    // solution 1
    // keep the current non-overlap group end, increase count when overlap
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int ret = 0;
        int end = Integer.MIN_VALUE; // non-overlap group end
        for (Interval cur : intervals) {
            if (cur.start >= end)
                end = cur.end;
            else
                ret++;
        }
        return ret;
    }
}
