class WordDictionary {

    private final TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('0');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char w : word.toCharArray()) {
            if (!cur.children.containsKey(w)) {
                cur.children.put(w, new TrieNode(w));
            }
            cur = cur.children.get(w);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word.toCharArray(), 0);
    }

    private boolean dfs(TrieNode node, char[] word, int pos) {
        if (node == null)
            return false;
        if (pos >= word.length)
            return node.isWord;
        if (word[pos] != '.') {
            return dfs(node.children.get(word[pos]), word, pos + 1);
        }
        for (TrieNode next : node.children.values()) {
            if (dfs(next, word, pos + 1))
                return true;
        }
        return false;
    }

    class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode(char c) {
            this.c = c;
            isWord = false;
            children = new HashMap<>();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
