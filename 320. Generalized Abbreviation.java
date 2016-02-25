public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        if(word == null)  return result;
        
        generateAbbreviations(word, result, 0, 0, "");
        return result;
    }
    
    private void generateAbbreviations(String word, List<String> result, int idx, int num, String prefix) {
        // base case
        if(idx == word.length()){
            if(num != 0) {
                prefix += num;
            }
            result.add(prefix);
            return ;
        }
        
        // 2 branches: 1. char 2. int
        // int
        generateAbbreviations(word, result, idx+1, num+1, prefix);
        
        // char
        if(num != 0) {
            prefix += num;
            num = 0;
        }
        generateAbbreviations(word, result, idx+1, num, prefix+word.charAt(idx));
        
    }
}
