public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        int len = s.length();
        List<String> result = new LinkedList<String>();
        
        if(len < 2) {
            return result;
        }
        
        boolean prevPlus = s.charAt(0) == '+' ? true:false;
        for(int i = 1; i < len; i++) {
            boolean current = s.charAt(i) == '+' ? true:false;
            if(prevPlus && current) {
                result.add(s.substring(0, i-1) + "--" + s.substring(i+1, len));
            } 
            prevPlus = current;
        }
        return result;
    }
}
