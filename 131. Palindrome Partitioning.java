public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null)   return result;
        
        dfs(s, 0, result, new LinkedList<String>());
        return result;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        if(i == j)  return true;
        for(int lo = i, hi =j; lo < hi; lo++, hi-- ) {
            if(s.charAt(lo) != s.charAt(hi))    return false;
        }
        return true;
    }
    
    private void dfs(String s, int cur, List<List<String>> result, LinkedList<String> list) {
        if(cur == s.length()) {
            result.add(new ArrayList<String>(list));
        }
        
        for(int i = cur; i < s.length(); i++) {
            if(isPalindrome(s, cur, i)) {
                list.add(s.substring(cur, i+1));
                dfs(s, i+1, result, list);
                list.removeLast();
            }
        }
    }
}
