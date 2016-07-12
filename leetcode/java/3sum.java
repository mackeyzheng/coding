public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int i = 0;
        while (i < num.length - 2) {
            int p = i + 1;
            int q = num.length - 1;
            while (p < q) {
                int sum = num[i] + num[p] + num[q];
                if (sum < 0) {
                    // update p
                    do {
                        p++;
                    } while (p < q && num[p] == num[p - 1]);
                } else {
                    if (sum == 0) {
                        Integer[] entry = {num[i], num[p], num[q]};
                        ret.add(new ArrayList<Integer>(Arrays.asList(entry)));
                    }
                    // update q
                    do {
                        q--;
                    } while(p < q && num[q] == num[q + 1]);
                }
            }

            // update i
            do {
                i++;
            } while (i < num.length - 2 && num[i] == num[i - 1]);
        }
        return ret;
    }
}
