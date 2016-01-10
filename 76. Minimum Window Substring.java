public class Solution {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        HashMap<Character, Integer> char2i = new HashMap<Character, Integer>();
        
        int index = 0;
        ArrayList<Integer> cnts = new ArrayList<Integer>();
        for(int k = 0; k < lenT; k++) {
            char c = t.charAt(k);
            if(!char2i.containsKey(c)) {
                char2i.put(c, index);
                cnts.add(1);
                index++;
            } else {
                int i = char2i.get(c);
                cnts.set(i, cnts.get(i) + 1);
            }
        }
        
        int sizeT = index;
        LinkedList<Integer> window = new LinkedList<Integer>();
        int[] freq = new int[sizeT];  
        int found = 0;
        int min = Integer.MAX_VALUE;
        String minStr = "";
        
        
        for(int i = 0; i < lenS; i++) {
            char c = s.charAt(i);
            if(char2i.containsKey(c)){
                int ci = char2i.get(c);
                freq[ci]++;
                
                if(freq[ci] == cnts.get(ci)) {
                    found++;
                }
                
                window.add(i);
                
                    if(freq[ci] > cnts.get(ci)){ 
                        // freq[ci] > ... ; can use assert here
                        char headChar = s.charAt(window.get(0));
                        int charI = char2i.get(headChar);
                        while(freq[charI] > cnts.get(charI)) {
                            window.removeFirst();
                            freq[charI]--;
                            headChar= s.charAt(window.get(0));
                            charI = char2i.get(headChar);
                        }
                    }
                    
                if(found >= sizeT) {
                    int winLen = getWinLen(window);
                    if(min > winLen) {
                        min = winLen;
                        minStr = s.substring(window.get(0), window.get(window.size() - 1)+1);
                    }
                } 
            }
        }
        return minStr;
    }
    
    private int getWinLen(LinkedList<Integer> window) {
        int last = window.size() - 1;
        return window.get(last) - window.get(0) + 1;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"a"
"aa"
Output:
"a"
Expected:
""
*/
