public class Solution {
    	public List<String> generatePalindromes(String s) {
        List<String> result = new LinkedList<String>();
        if(s == null) return result;
        
        HashMap<Character, Integer> char2cnt = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(char2cnt.containsKey(s.charAt(i))){
                char2cnt.put(s.charAt(i), char2cnt.get(s.charAt(i)) + 1);
            } else {
                char2cnt.put(s.charAt(i), 1);
            }
        }
        
        int oddNum = 0;
        char oddChar = 'a';
        for(Character c:char2cnt.keySet()){
            if(char2cnt.get(c) % 2 == 1){
                oddNum += 1;
                if(oddNum > 1) {
                    return result;
                }
                oddChar = c;
                char2cnt.put(c, char2cnt.get(c) - 1);
            }
        }

        if(char2cnt.keySet().size() == 1){
            result.add(s);
            return result;
        }
        
        
        List<String> prefixList = new LinkedList<String>();
        generatePalindromes(char2cnt, "", prefixList);
        
        for(String prefix:prefixList) {
            StringBuilder builder = new StringBuilder(prefix);
            if(oddNum == 1) {
                builder.append(oddChar);
            }
            for(int i = prefix.length() - 1; i > -1; i--){
                builder.append(prefix.charAt(i));
            }
            result.add(builder.toString());
        }

        return result;
    }
    
    public void generatePalindromes(HashMap<Character, Integer> char2cnt, String prefix, List<String> prefixList) {
        boolean empty = true;
        for(Character c:char2cnt.keySet()){
            
            int cnt = char2cnt.get(c);
            if(cnt == 0) {
                continue;
            }
            if(empty == true) {
            	empty = false;
            }
            
            char2cnt.put(c, cnt-2);
            
            generatePalindromes(char2cnt, prefix + c, prefixList);
            
            char2cnt.put(c, cnt);
            
        }
        if(empty) {
        	prefixList.add(prefix);
        }
    }

}

/*
Runtime Error More Details 

Runtime Error Message:
Line 66: java.lang.StackOverflowError
Last executed input:
"aab"
*/
