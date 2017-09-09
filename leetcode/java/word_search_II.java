class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // build trie
        root = new TrieNode();
        for (String w : words) {
            insert(w);
        }
        List<String> ret = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bt(ret, board, i, j, visited, root);
            }
        }
        return ret;
    }

    private void bt(List<String> ret, char[][] board, int x, int y, boolean[][] visited, TrieNode node) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if (visited[x][y] || node == null || !node.children.containsKey(board[x][y])) return;
        visited[x][y] = true;
        node = node.children.get(board[x][y]);
        if (node.hasWord) {
            ret.add(node.word);
            node.hasWord = false; // avoid adding duplicate words in ret
        }

        // keep bt
        bt(ret, board, x-1, y, visited, node);
        bt(ret, board, x+1, y, visited, node);
        bt(ret, board, x, y-1, visited, node);
        bt(ret, board, x, y+1, visited, node);

        visited[x][y] = false;
    }

    class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean hasWord;
        String word;

        TrieNode() {
            children = new HashMap<>();
            hasWord = false;
            word = null;
        }

        TrieNode(char c) {
            this();
            this.c = c;
        }
    }

    private TrieNode root;

    private void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
        }
        node.hasWord = true;
        node.word = word;
    }

}
