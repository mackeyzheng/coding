public class Solution {
    // rolling array backward, do not need to keep previous value
    // solution 1: with aux int array
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        if (rowIndex < 0)
            return row;

        Integer[] data = new Integer[rowIndex+1];
        Arrays.fill(data, 1);
        for (int j = 2; j <= rowIndex; j++) {
            for (int i = j - 1; i > 0; i--) {
                data[i] = data[i] + data[i-1];
            }
        }
        row.addAll(Arrays.asList(data)); // Integer[] instead of int[]
        return row;
    }

//     // solution 2: without aux int array
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> ret = new ArrayList<Integer>();
//         for (int i = 0; i <= rowIndex; i++) {
//             for (int j = i - 1; j > 0; j--) {
//                 ret.set(j, ret.get(j-1) + ret.get(j));
//             }
//             ret.add(1);
//         }
//         return ret;
//     }
}
