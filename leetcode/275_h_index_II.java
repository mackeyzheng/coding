class Solution {
    // binary search by h range
    public int hIndex(int[] citations) {
        final int N = citations.length;
        // h -> [0,...,N]
        int i = 0;
        int j = N;
        // we know there is a solution for certain, so use i < j
        while (i < j) {
            int mid = i + (j - i) / 2;
            // since j can be N, so check array out of boundary
            if (mid == N) {
                return 0;
            }
            int rank = N - mid;
            if (citations[mid] == rank) {
                return rank;
            }
            if (citations[mid] < rank) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return N - i;
    }
}
