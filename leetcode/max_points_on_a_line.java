/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    // brute force: O(n^2), O(n)
    // take a certain point, considering all lines through this point
    //  all the other points which has the same slope are on the same line
    // note that: there may be duplicate points
    // issues:
    //      1. duplicate points
    //      2. infinity slope
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 3) return points.length;

        int ret = 0;
        // TODO: instead of storing double, store String "x/y" as key, where x is x/=gcd(point i, j) and y is y/=gcd(point i, j)
        Map<Double, Integer> map = new HashMap<Double, Integer>(); // key: slope value: number of points
        for (int i = 0; i < points.length - 1; i++) {
            map.clear();
            int samePoint = 0; // no. of duplicate points with point i
            int maxPoint = 1;  // the max number of points on the same line with point i
            for (int j = i + 1; j < points.length; j++) {
                double slope = 0.0;
                if (points[i].x == points[j].x) {
                    slope = Double.MAX_VALUE;
                    if (points[i].y == points[j].y) {
                        samePoint++;
                        continue;
                    }
                } else {
                    // note here: 0.0 and -0.0 are different in Java
                    // -0.0 + 0.0 --> 0.0
                    slope = 0.0 + 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                }
                
                int count = 0;
                if (map.containsKey(slope))
                    count = map.get(slope) + 1;
                else
                    count = 2;

                map.put(slope, count);

                if (count > maxPoint)
                    maxPoint = count;
            }

            ret = Math.max(ret, samePoint + maxPoint);
        }

        return ret;
    }
}
