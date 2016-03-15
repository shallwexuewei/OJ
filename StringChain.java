/*
 * Complete the function below.
 */

    static int longest_chain(String[] w) {
        if(w == null || w.length == 0) {
            return 0;
        }
               
        // Divid the words into different hashSet depending on their word length
        TreeMap<Integer, HashSet<String>> length2wordSet = new TreeMap<>(); 
        
        // add words into the treeMap length2wordSet, 
        for(String word:w) {
            int len = word.length();
            if(length2wordSet.containsKey(len)) {
                length2wordSet.get(len).add(word);
            } else {
                HashSet<String> wordSet = new HashSet<>();
                wordSet.add(word);
                length2wordSet.put(len, wordSet);
            }
        }
        
        // use a hashMap to store the maximum chian length of every word we have traversed
        // in order to save space, we don't store the words that can only form chain with itself (namely chain length is only 1).
        HashMap<String, Integer> word2maxChainLen = new HashMap<>();
        
        // the variable we need to return
        int maxChainLen = 1;
        
        // traverse the word lengths in ascending order.
        for(int wordLen : length2wordSet.keySet()) {
            // if there is no words whose length is one shorter than current wordLen
            // then we cannot form chain.
            if(!length2wordSet.containsKey(wordLen - 1)) {
                continue;
            }
            
            
            HashSet<String> wordSet = length2wordSet.get(wordLen);
            HashSet<String> shorterWordSet = length2wordSet.get(wordLen - 1);
            
            // traverse all words in wordSet
            for(String word:wordSet) {
                
                int currentMaxChainLen = 0;
                // enumerate all possible words by removing one character of current word.
                for(int i = 0; i < wordLen; i++) {
                    String shorterWord = word.substring(0, i) + word.substring(i+1, wordLen);
                    
                    // if the shorter word can form a chain with even shorter words
                    // then build chain based on it.
                    if (word2maxChainLen.containsKey(shorterWord)) { 
                        int chainLen = word2maxChainLen.get(shorterWord) + 1; 
                        if(currentMaxChainLen < chainLen) {
                            currentMaxChainLen = chainLen;
                        }
                    } 
                    
                    // else if the shorter word is in the dictionary.
                    else if(shorterWordSet.contains(shorterWord)) {
                        if(currentMaxChainLen < 2) {
                            currentMaxChainLen = 2;
                        }
                    }
                }
                
                // if the word can form a chain, put it in the HashMap
                if(currentMaxChainLen > 1) {
                    word2maxChainLen.put(word, currentMaxChainLen);
                }
                
                // update maxChainLen
                if(currentMaxChainLen > maxChainLen) {
                    maxChainLen = currentMaxChainLen;
                }
            }
        }
        
        return maxChainLen;
    }
