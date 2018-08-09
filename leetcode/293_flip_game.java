class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != '+' || array[i+1] != '+') continue;
            array[i] = '-';
            array[i + 1] = '-';
            ret.add(String.valueOf(array));
            array[i] = '+';
            array[i + 1] = '+';
        }
        return ret;
    }
}
