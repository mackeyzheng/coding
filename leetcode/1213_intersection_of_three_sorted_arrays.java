class Solution {
    // similar to intersection of two sorted arrays
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ret.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                int max = Math.max(Math.max(arr1[i], arr2[j]), arr3[k]);
                if (arr1[i] < max) {
                    i++;
                }
                if (arr2[j] < max) {
                    j++;
                }
                if (arr3[k] < max) {
                    k++;
                }
            }
        }
        return ret;
    }

    // recursion: scalable to N arrays
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = intersection(arr1, arr2);
        return intersection(arr3, list.stream().mapToInt(i->i).toArray());
    }

    private List<Integer> intersection(int[] arr1, int[] arr2) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                ret.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ret;
    }
}
