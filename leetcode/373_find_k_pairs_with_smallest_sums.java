class Solution {
    // min heap, time O(klgn), n is the length of nums1
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return ret;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]); // {sum, i, j}
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[] { nums1[i] + nums2[0], i, 0 }); // initialize to (i, 0)
        }
        for (int kk = 0; kk < k; kk++) {
            // k is larger than nums1.length * nums2.length
            if (pq.isEmpty()) {
                break;
            }
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            ret.add(new int[]{nums1[i], nums2[j]});

            if (j == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
        }
        return ret;
    }

    // O(kn1), index[i] is to record the min index at nums2 for i at nums1
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return ret;
        }
        int[] index = new int[nums1.length];
        while (k > 0) {
            int minSum = Integer.MAX_VALUE;
            int minIdx = 0;
            boolean status = false;
            for (int i = 0; i < nums1.length; i++) {
                status |= index[i] < nums2.length;
                if (index[i] < nums2.length && nums1[i] + nums2[index[i]] < minSum) {
                    minSum = nums1[i] + nums2[index[i]];
                    minIdx = i;
                }
            }
            // k > n1 * n2
            if (!status) {
                break;
            }
            ret.add(new int[]{nums1[minIdx], nums2[index[minIdx]]});
            index[minIdx]++;
            k--;
        }
        return ret;
    }

    // min heap + hashmap (visited map), visited map is to avoid duplicate
    // time O(klg(n1+n2))
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return ret;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]); // {sum, i, j}
        pq.offer(new int[] { nums1[0] + nums2[0], 0, 0 }); // offer the minimum
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;
        for (int kk = 0; kk < k; kk++) {
            // k is larger than nums1.length * nums2.length
            if (pq.isEmpty()) {
                break;
            }
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            ret.add(new int[] { nums1[i], nums2[j] });

            if (i + 1 < nums1.length && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                pq.offer(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
            }

            if (j + 1 < nums2.length && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                pq.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }
        }
        return ret;
    }
}
