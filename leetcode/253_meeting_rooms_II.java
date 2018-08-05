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

    // solution1: min stack, time O(nlgn)
    // group non-overlap intervals by merging them, keep the min end timestamp
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // sort by start time
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        // use a min heap to track the min end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval cur = heap.poll();
            if (intervals[i].start >= cur.end) {
                // no need for a new room, merge the interval
                cur.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // put the meeting room back
            heap.offer(cur);
        }

        return heap.size();
    }

    // solution2: time O(nlgn)
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int j = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[j])
                rooms++;
            else
                j++;
        }
        return rooms;
    }
}
