public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int j = 0; j < numRows; j++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i < j; i++)
                row.add(ret.get(j-1).get(i-1) + ret.get(j-1).get(i));
            
            if (j > 0)
                row.add(1);

            ret.add(row);
        }

        return ret;
    }
}
