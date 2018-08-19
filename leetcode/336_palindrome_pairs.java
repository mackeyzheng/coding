class Solution {
    // Trie - customized version of a Trie
    // O(n * k^2)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        TrieNode root = new TrieNode(); // build a postfix trie
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words, i, ret);
        }
        return ret;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (root.next[c] == null) root.next[c] = new TrieNode();
            if (isPalindrome(word, 0, i)) root.list.add(index);
            root = root.next[c];
        }
        root.list.add(index);
        root.index = index;
    }

    private void search(TrieNode root, String[] words, int index, List<List<Integer>> ret) {
        String word = words[index];
        for (int i = 0; i < word.length(); i++) {
            if (root.index >= 0 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
                ret.add(Arrays.asList(index, root.index));
            }
            root = root.next[word.charAt(i)];
            if (root == null) return;
        }
        for (int j : root.list) {
            if (index != j) {
                ret.add(Arrays.asList(index, j));
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    class TrieNode {
        int index;
        TrieNode[] next;
        List<Integer> list;
        TrieNode() {
            index = -1;
            next = new TrieNode[256];
            list = new ArrayList<>();
        }
    }
}
