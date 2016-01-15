public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>(); 
        dfs(word, 0, "", 0, res);
        return res;
    }
    
    private void dfs(String word, int depth, String prefix, int count, List<String> res) {
        int len = word.length();
        // base case 
        if(depth == len) {
            if(count > 0) {
                prefix += count;
            }
            res.add(prefix);
            return;
        }
        
        // abbreviate
        dfs(word, depth+1, prefix, count + 1, res);
        
        // remain
        if(count > 0) {
            prefix += count;
        }
        dfs(word, depth+1, prefix + word.charAt(depth), 0, res);
        
    }
}
