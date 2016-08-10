/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;

        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private void qsort(String[] nuts, String[] bolts, NBComparator compare, int s, int e) {
        if (s >= e) return;
        // find the partition index for nuts with bolts[s]
        int partIndex = partition(nuts, bolts[s], compare, s, e);
        // partition bolts with nuts[partIndex]
        partition(bolts, nuts[partIndex], compare, s, e);
        // qsort recursively
        qsort(nuts, bolts, compare, s, partIndex - 1);
        qsort(nuts, bolts, compare, partIndex + 1, e);
    }

    private int partition(String[] str, String pivot, NBComparator compare, int s, int e) {
        // find pivot, swap to s
        for (int i = s; i <= e; i++) {
            if (compare.cmp(str[i], pivot) == 0
                || compare.cmp(pivot, str[i]) == 0) {
                swap(str, i, s);
                break;
            }
        }

        String cur = str[s];
        int left = s;
        int right = e;
        while (left < right) {
            while (left < right
                    && (compare.cmp(str[right], pivot) == 1
                        || compare.cmp(pivot, str[right]) == -1)) {
                right--;
            }
            str[left] = str[right];

            while (left < right
                    && (compare.cmp(str[left], pivot) == -1
                        || compare.cmp(pivot, str[left]) == 1)) {
                left++;
            }
            str[right] = str[left];
        }
        str[left] = cur;
        return left;
    }

    private void swap(String[] str, int i, int j) {
        String tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
};
