class Solution {
    // bucket sort: O(n)
    public int hIndex(int[] citations) {
        final int N = citations.length;
        int[] count = new int[N+1];
        for (int num : citations) {
            count[Math.min(num, N)]++;
        }
        int sum = 0;
        for (int i = N; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    // quick-sort: O(nlgn)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        final int N = citations.length;
        Arrays.sort(citations);
        int i = 0;
        while (i < N) {
            if (N - i <= citations[i]) {
                break;
            }
            i++;
        }
        return N - i;
    }
}
