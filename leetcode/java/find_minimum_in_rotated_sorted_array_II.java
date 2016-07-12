// duplicates are allowed
public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return -1;

        int s = 0;
        int e = num.length - 1;
        while (s < e) {
            int m = s + ((e - s) >> 1);
            if (num[m] > num[e]) {
                s = m + 1;
            } else if (num[m] < num[e]) {
                e = m;
            } else {    // num[m] = num[e]
                if (num[s] == num[m]) {
                    s++;
                    e--;
                } else {
                    e = m;
                }
            }
        }

        return num[e];
    }

//    public int findMin(int[] num) {
//        if (num == null || num.length == 0) return -1;
//
//        int s = 0;
//        int e = num.length - 1;
//        while (s < e - 1) {
//            int m = s + ((e - s) >> 1);
//            if (num[s] < num[m]) {
//                if (num[m] > num[e])
//                    s = m;
//                else
//                    e = m;
//            } else if (num[s] > num[m]) {
//                e = m;
//            } else {
//                s++;
//            }
//        }
//
//        return Math.min(num[s], num[e]);
//    }
}
