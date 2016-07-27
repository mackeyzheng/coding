public class Solution {
    /**
     * sift down, O(n)
     *
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        for (int i = A.length/2; i >= 0; i--)
            siftdown(A, i);
    }

    private void siftdown(int[] A, int p) {
        while (p < A.length) {
            int smallest = p;
            int left = 2 * p + 1;
            int right = 2 * p + 2;
            if (left < A.length && A[left] < A[smallest])
                smallest = left;
            
            if (right < A.length && A[right] < A[smallest])
                smallest = right;

            if (smallest == p)
                break;

            // swap
            int tmp = A[smallest];
            A[smallest] = A[p];
            A[p] = tmp;

            // update
            p = smallest;
        }
    }

    ///**
    // * sift up, O(nlogn)
    // *
    // * @param A: Given an integer array
    // * @return: void
    // */
    //public void heapify(int[] A) {
    //    for (int i = 0; i < A.length; i++)
    //        siftup(A, i);
    //}

    //private void siftup(int[] A, int p) {
    //    while (p != 0) {
    //        int father = (p - 1) / 2;
    //        if (A[p] > A[father])
    //            break;

    //        // swap
    //        int tmp = A[p];
    //        A[p] = A[father];
    //        A[father] = tmp;

    //        // update
    //        p = father;
    //    }
    //}
}
