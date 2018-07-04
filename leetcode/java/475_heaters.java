class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        final int M = houses.length;
        final int N = heaters.length;
        int res = -1;
        int i = 0;
        int j = 0;
        while (i < M) {
            int mid = j+1 < N ? heaters[j] + (heaters[j+1] - heaters[j]) / 2 : Integer.MAX_VALUE;
            if (houses[i] <= mid) {
                res = Math.max(res, Math.abs(heaters[j] - houses[i]));
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
