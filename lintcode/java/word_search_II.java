public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> ret = new ArrayList<>();

        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                dfs(board, i, j, tree.root, ret);

        return ret;
    }

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    // iterate board
    private void dfs(char[][] board, int x, int y, TrieNode node, ArrayList<String> ret) {
        if (node.hasWord == true && !ret.contains(node.word))
            ret.add(node.word);

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0)
            return;

        if (node.children.containsKey(board[x][y])) {
            for (int i = 0; i < 4; i++) {
                char cur = board[x][y];
                board[x][y] = 0;
                dfs(board, x+dx[i], y+dy[i], node.children.get(cur), ret);
                board[x][y] = cur;
            }
        }
    }

    class TrieNode {
        char c;
        String word;
        boolean hasWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
            hasWord = false;
        }

        TrieNode(char c) {
            this();
            this.c = c;
        }
    }

    class TrieTree {
        TrieNode root;
        TrieTree() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c))
                    cur.children.put(c, new TrieNode(c));
                cur = cur.children.get(c);
            }
            cur.hasWord = true;
            cur.word = word;
        }

        boolean search(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c))
                    return false;
                cur = cur.children.get(c);
            }
            return cur.hasWord;
        }
    }
}
