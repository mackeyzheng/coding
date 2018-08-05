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
    // O(nlgn) - sort interval
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        }
        return true;
    }

    // O(nlgn) - sort start and end points separately
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 1; i < intervals.length; i++) {
            if (start[i] < end[i - 1])
                return false;
        }
        return true;
    }
}
