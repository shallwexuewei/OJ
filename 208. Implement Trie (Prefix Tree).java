class TrieNode {
    HashMap<Character, TrieNode> char2node;
    
    // Initialize your data structure here.
    public TrieNode() {
        char2node = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode get(Character c) {
        if(char2node.containsKey(c)) {
            return char2node.get(c);
        }
        return null;
    }
    
    public void put(String s, int i) {
        TrieNode child = new TrieNode();
        char2node.put(s.charAt(i), child);
        i++;
        if(i < s.length()) {
            child.put(s, i);
        } else if(i == s.length()) {
            child.char2node.put('\0', null);
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = null;
        TrieNode prev = root;
        for(int i = 0; i < word.length(); i++) {
            node = prev.get(word.charAt(i));
            if(node == null) {
                prev.put(word, i);
                break;
            } else{
                prev = node;
            }
        }
        
        /* don't forget this!!! */
        if(node != null) {
            node.char2node.put('\0', null);
        }
    }
    
    private TrieNode getNextNode(String word) { 
        TrieNode node = null;
        TrieNode prev = root;
        for(int i = 0; i < word.length(); i++) {
            node = prev.get(word.charAt(i));
            if(node == null) {
                return null;
            }
            prev = node;
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode res = getNextNode(word);
        if(res == null ) {
            return false;
        }
        if(res.char2node.containsKey('\0') == false) {
            return false;
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(getNextNode(prefix) != null) {
            return true;
        }
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 42: java.lang.NullPointerException
Last executed input:
insert("a"),search("a"),startsWith("a")



Submission Result: Wrong Answer More Details 

Input:
insert("abc"),search("abc"),search("ab"),insert("ab"),search("ab"),insert("ab"),search("ab")
Output:
[true,false,false,false]
Expected:
[true,false,true,true]
*/
