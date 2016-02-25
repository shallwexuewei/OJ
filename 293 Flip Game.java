public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        if(s == null)   {
            //...
        }
        
        List<String> result = new ArrayList<String>();
        char[] chars = s.toCharArray();
        
        for(int i = 1; i < s.length(); i++) {
            if(chars[i] == '+') {
                if(chars[i-1] == '+') {
                    chars[i-1] = '-';
                    chars[i] = '-';
                    result.add(new String(chars));
                    chars[i-1] = '+';
                    chars[i] = '+';
                }
            }
        }
        return result;
    }
}
