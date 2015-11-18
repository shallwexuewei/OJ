public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        int len = s.length();
        List<String> result = new LinkedList<String>();
        
        if(len <= 2) {
            return result;
        }
        
        char prev = s.charAt(0);
        for(int i = 1; i < len; i++) {
            char current = s.charAt(i);
            if(current == prev) {
                char newC = '+';
                if(current == '+') newC = '-';
                if(i != 1 && i + 1 != len) {
                    result.add(s.substring(0, i-1) + newC + newC + s.substring(i+1, len));
                }
                else if(i + 1 != len) {
                    result.add(""+ newC + newC + s.substring(i+1, len));
                }
                else  if(i != 1 ) {
                    result.add(s.substring(0, i-1) + newC + newC);
                } else {
                    result.add("" + newC + newC);
                }
            }
            prev = current;
        }
        return result;
    }
}
