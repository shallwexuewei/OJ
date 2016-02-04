public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord))   return 1;
        
        HashSet<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        HashSet<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int level = 2;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                HashSet<String> swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }
            wordList.removeAll(beginSet);
            HashSet<String> newBeginSet = new HashSet<>();
            for(String word:beginSet) {
                char[] cs = word.toCharArray();
                for(int i = 0; i < cs.length; i++) {
                    char original = cs[i];
                    for(char c = 'a'; c < 'z'; c++) {
                        if(c != original) {
                            cs[i] = c;
                            String str = new String(cs);
                            if(endSet.contains(str)){
                                return level;
                            } else if(wordList.contains(str)){
                                newBeginSet.add(str);
                            }
                        }
                    }
                    cs[i] = original;
                }
            }
            beginSet = newBeginSet;
            level++;
        }
        return 0;
    }
}
