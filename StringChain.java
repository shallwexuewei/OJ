/*
 * Complete the function below.
 */

    static int longest_chain(String[] w) {
        if(w == null || w.length == 0) {
            return 0;
        }
        
        TreeMap<Integer, HashSet<String>> length2wordSet = new TreeMap<>();
        TreeSet<Integer> wordLenSet = new TreeSet<>();
        
        for(String word:w) {
            int len = word.length();
            wordLenSet.add(len);
            if(length2wordSet.containsKey(len)) {
                length2wordSet.get(len).add(word);
            } else {
                HashSet<String> wordSet = new HashSet<>();
                wordSet.add(word);
                length2wordSet.put(len, wordSet);
            }
        }
        
        HashMap<String, Integer> word2maxChainLen = new HashMap<>();
        int maxChainLen = 1;
        for(int wordLen : length2wordSet.keySet()) {
            if(wordLen < 2) {
                continue;
            }
            
            if(!length2wordSet.containsKey(wordLen - 1)) {
                continue;
            }
            
            HashSet<String> wordSet = length2wordSet.get(wordLen);
            HashSet<String> shorterWordSet = length2wordSet.get(wordLen - 1);
            for(String word:wordSet) {
                int currentMaxChainLen = 0;
                for(int i = 0; i < wordLen; i++) {
                    String shorterWord = word.substring(0, i) + word.substring(i+1, wordLen);
                    if(shorterWordSet.contains(shorterWord)) {
                        
                    }
                }
            }
        }
        
        return maxChainLen;
    }
