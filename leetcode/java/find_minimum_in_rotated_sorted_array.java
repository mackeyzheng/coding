public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return -1;

        int s = 0;
        int e = num.length - 1;
        while (s < e) {
            int m = s + ((e - s) >> 1);
            if (num[m] > num[e])
                s = m + 1;
            else
                e = m;
        }

        return num[e];
    }
    
//    public int findMin(int[] num) {
//        if (num == null || num.length == 0) return -1;
//
//        int s = 0;
//        int e = num.length - 1;
//        int ret = -1;
//        while (s <= e) {
//            if (num[s] <= num[e]) {
//                ret = num[s];
//                break;
//            }
//
//            int m = s + ((e - s) >> 1);
//            if (num[s] <= num[m])
//                s = m + 1;
//            else
//                e = m;
//        }
//
//        return ret;
//    }

//    public int findMin(int[] num) {
//        if (num == null || num.length == 0) return -1;
//
//        int s = 0;
//        int e = num.length - 1;
//        while (s < e - 1) {
//            int m = s + ((e - s) >> 1);
//            if (num[s] <= num[m] && num[m] > num[e])
//                s = m;
//            else
//                e = m;
//        }
//
//        return Math.min(num[s], num[e]);
//    }
}
