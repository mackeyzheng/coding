class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty())
            return true;
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == array[0] && find(board, i, j, array, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, char[] word, int pos, Set<Integer> visited) {
        if (pos >= word.length)
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        int cur = i * board[0].length + j;
        if (visited.contains(cur) || board[i][j] != word[pos])
            return false;
        visited.add(cur);
        boolean status = find(board, i + 1, j, word, pos + 1, visited) || find(board, i - 1, j, word, pos + 1, visited)
                || find(board, i, j + 1, word, pos + 1, visited) || find(board, i, j - 1, word, pos + 1, visited);
        visited.remove(cur);
        return status;
    }
}
