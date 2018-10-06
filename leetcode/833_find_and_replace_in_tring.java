class Solution {
    // no sort, use a match index array to store
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S.isEmpty() || indexes.length == 0) {
            return S;
        }

        final int N = indexes.length;
        // if the substring starts from position i can match a source
        // -1 means no mathc, otherwise store the index
        int[] matches = new int[S.length()];
        Arrays.fill(matches, -1);
        for (int i = 0; i < N; i++) {
            int start = indexes[i];
            int end = start + sources[i].length() - 1;
            if (end < S.length() && S.substring(start, end + 1).equals(sources[i])) {
                matches[start] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (matches[i] == -1) {
                sb.append(S.charAt(i));
            } else {
                sb.append(targets[matches[i]]);
                i += sources[matches[i]].length() - 1; // note i++ at the end of for loop
            }
        }
        return sb.toString();
    }

    // sort and check one-by-one
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S.isEmpty() || indexes.length == 0) {
            return S;
        }

        final int N = indexes.length;
        StringBuilder sb = new StringBuilder();
        char[] array = S.toCharArray();
        int[][] sortedIdx = new int[N][2];
        for (int i = 0; i < N; i++) {
            sortedIdx[i] = new int[] { i, indexes[i] };
        }
        Arrays.sort(sortedIdx, (a, b) -> a[1] - b[1]);

        int p = 0;
        for (int i = 0; i < N; i++) {
            while (p < sortedIdx[i][1]) {
                sb.append(array[p++]);
            }
            if (isMatch(array, p, sources[sortedIdx[i][0]])) {
                sb.append(targets[sortedIdx[i][0]]);
                p += sources[sortedIdx[i][0]].length();
            }
        }

        while (p < array.length) {
            sb.append(array[p++]);
        }

        return sb.toString();
    }

    private boolean isMatch(char[] array, int p, String str) {
        int q = 0;
        while (p < array.length && q < str.length()) {
            if (array[p] != str.charAt(q)) {
                return false;
            }
            p++;
            q++;
        }
        return q >= str.length();
    }

}
