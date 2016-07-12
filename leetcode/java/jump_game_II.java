public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length < 2) return 0;
        int step = 0;
        int left = 0;
        int right = 0; // current coverage A[left, right]
        while (left <= right) {
            step++;
            final int old_right = right;
            for (int i = left; i <= old_right; i++) {
                right = Math.max(right, i + A[i]);
                if (right >= A.length - 1) return step;
            }
            left = old_right + 1;
        }
        return 0; // just a fake value
    }

    // my own solution
//    public int jump(int[] A) {
//        if (A == null || A.length < 2) return 0;
//        int step = 1;
//        int i = 0;
//        int far = A[0];
//        while (far < A.length - 1) {
//            int new_far = -1;
//            for (int j = i; j <= far; j++) {
//                new_far = Math.max(new_far, j + A[j]);
//                if (new_far >= A.length - 1) return ++step;
//            }
//            i = far + 1;
//            far = new_far;
//            step++;
//        }
//        return step;
//    }
}
