public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null)       return s;
        if(s.length() == 0) return s;
        
         
        ArrayList<LinkedList<Integer>> indices = new ArrayList<LinkedList<Integer>>(26); 
        
        for(int i = 0; i < 26; i++) {
            indices.add(new LinkedList<Integer>());
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            indices.get(c-'a').add(i);
        }
        
        StringBuilder builder = new StringBuilder();
        int prev = -1;
        while(true) {
            int cnt = 26;
            for(int i = 0; i < 26; i++) {
                LinkedList<Integer> list = indices.get(i);
                if(list.isEmpty()){
                    cnt--;
                    continue;
                }
                Integer leftmost = list.get(0);
                while(leftmost < prev) { 
                    list.removeFirst();
                    leftmost = list.get(0);
                }
                int j = i + 1;
                for( ; j < 26; j++) {
                    LinkedList<Integer> listJ = indices.get(j);
                    if(listJ.isEmpty()) {
                        continue;
                    }
                    if(leftmost > listJ.get(listJ.size()-1)) {
                        break;   
                    }
                }
                if(j == 26) {
                    builder.append((char) (i+'a'));
                    prev = leftmost;
                    indices.get(i).clear();
                    break;
                }
            }
            if(cnt == 0) {
                break;
            }
        }
        return builder.toString();
        
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"cbacdcbc"
Output:
"badc"
Expected:
"acdb"

Submission Result: Wrong Answer More Details 

Input:
"bbacb"
Output:
"abc"
Expected:
"acb"
*/
