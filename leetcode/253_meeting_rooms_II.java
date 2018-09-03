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
    // heap
    // O(nlgn)
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // store ends
        int max = 0;
        for (Interval cur : intervals) {
            while (!pq.isEmpty() && pq.peek() <= cur.start) {
                pq.poll();
            }
            pq.offer(cur.end);
            max = Math.max(max, pq.size());
        }
        return max;
    }

    // sweep line
    // O(nlgn)
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < intervals.length) {
            while (i < intervals.length && starts[i] < ends[j]) { // [1,13], [13,15] does not overlap
                i++;
            }
            max = Math.max(max, i - j);
            if (i == intervals.length) break;
            while (j < intervals.length && ends[j] <= starts[i]) {
                j++;
            }
        }
        return max;
    }
}
