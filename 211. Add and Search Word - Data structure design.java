public class WordDictionary {
    private TrieNode root = new TrieNode();
    
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26]; // a-z
        }
        
        public void add(String word, int i) {
            int c = word.charAt(i) - 'a';
            children[c] = new TrieNode();
            i++;
            if(i < word.length()) {
                children[c].add(word, i);
            } else if(i == word.length()) {
                children[c].isWord = true;
            }
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode prev = root;
        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            node = prev.children[word.charAt(i) - 'a'];
            if(node == null) {
                prev.add(word, i);
                break;
            } else {
                prev = node;
            }
        }
        if(node != null) {
            node.isWord = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        return search(root, word, 0);
    }
    
    private boolean search(TrieNode node, String word, int d) {
        if(d == word.length()){
            return node.isWord;
        }
        
        char c = word.charAt(d);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    if(search(node.children[i], word, d+1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(node.children[c-'a'] == null) {
                return false;
            } else {
                return search(node.children[c-'a'], word, d+1);
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
