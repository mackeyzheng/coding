static int longestChain(String[] words) {
    if (words == null || words.length == 0) return 0;

    final int N = words.length;
    TreeMap<Integer, Set<String>> wordsByLen = new TreeMap<>();
    for (int i = 0; i < N; i++) {
        String word = words[i];
        Set<String> wordSet = wordsByLen.get(word.length());
        if (wordSet == null) {
            wordSet = new HashSet<>();
        }
        wordSet.add(word);
        wordsByLen.put(word.length, wordSet);
    }

    int ret = 0;
    for (Map.Entry<Integer, Set<String>> entry : wordsByLen.descendingMap().entrySet()) {
        Set<String> wordSet = entry.getValue();
        for (String word : wordSet) {
            ret = Math.max(ret, getChainLen(word, wordsByLen));
        }
    }

    return ret;
}

static int getChainLen(String word, Map<Integer, Set<String>> wordsByLen) {
    if (word.length() == 1) return 1;

    int chainLen = 1;
    for (int i = 0; i < word.length(); i++) {
        StringBuilder sb = new StringBuilder(word);
        sb.deleteCharAt(i);
        String newWord = sb.toString();

        Set<String> wordSet = wordsByLen.get(newWord.length());
        if (wordSet != null) {
            if (wordSet.remove(newWord)) {
                chainLen = Math.max(chainLen, getChainLen(newWord, wordsByLen) + 1);
            }
        }
    }

    return chainLen;
}
