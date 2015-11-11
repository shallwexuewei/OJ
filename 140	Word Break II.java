public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        
        HashMap<Integer, LinkedList<Integer>> parents = new HashMap<Integer, LinkedList<Integer>>();
        parents.put(0, null);
        for(int i = 0; i < len; i++) {
            if(parents.containsKey(i) == false){
                continue;
            }
            
            for(String word:wordDict) {
                int newStart = i+word.length();
                if(  newStart <= len && s.substring(i, newStart).equals(word) ){
                    if(parents.containsKey(newStart)){
                        parents.get(newStart).add(i);
                    } else {
                        LinkedList<Integer> list = new LinkedList<Integer>();
                        list.add(i);
                        parents.put(newStart, list);
                    }
                }
            }
        }
        
        List<String> result = new LinkedList<String>();
        if(parents.containsKey(len) == false){
            return result;
        }
        
        setResult(s, parents, result, "", len);
        return result;
    }
    
    public void setResult(String s, HashMap<Integer, LinkedList<Integer>> parents, List<String> result, String postfix, int end) {
        LinkedList<Integer> startList = parents.get(end);
        if(startList == null) {
            result.add(postfix);
            return;
        }
        for(int start:startList) {
            String newPostfix = s.substring(start, end);
            if(!postfix.isEmpty()){
                newProfix += " " + postfix;
            }
            setResult(s, parents, result,  newPostfix, start);
        }
    }
}
