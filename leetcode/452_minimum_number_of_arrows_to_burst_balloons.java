public class Solution {
    // sort by start point
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ret = 1;
        int curEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= curEnd) {
                curEnd = Math.min(curEnd, points[i][1]);
            } else {
                curEnd = points[i][1];
                ret++;
            }
        }
        return ret;
    }

    // sort by end point
    // greedy
    // We know that eventually we have to shoot down every balloon,
    // so for each ballon there must be an arrow whose position is between balloon[0] and balloon[1].
    // Given that, we can sort the array of balloons by their ending position.
    // Then we make sure that while we take care of each balloon from the beginning,
    // we can shoot as many following balloons as possible.
    // So what position should we pick? We should shoot as right as possible,
    // because all balloons' end position is to the right of the current one.
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int ret = 1;
        int arrowLimit = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrowLimit) continue;
            ret++;
            arrowLimit = points[i][1];
        }
        return ret;
    }
}
