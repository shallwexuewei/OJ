public class Solution { 
    
    public String minWindow(String s, String t) {
        HashMap<Character, LinkedList<Integer>> char2indices = new HashMap<Character, LinkedList<Integer>>();
        HashMap<Character, Integer> char2cnt = new HashMap<Character, Integer>();
        HashMap<Character, ArrayList<Integer>> window = new HashMap<Character, ArrayList<Integer>>(); 
        
        // O(T)
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(char2indices.containsKey(c)) {
                char2cnt.put(c, char2cnt.get(c) + 1);
                continue;
            } 
            char2indices.put(c, new LinkedList<Integer>());
            window.put(c, new ArrayList<Integer>());
            char2cnt.put(c, 1);
        }
        
        // O(S)
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(char2indices.containsKey(c)) {
                char2indices.get(c).add(i);
            }
        }
        
        int left = s.length();
        int right = 0;
        boolean fail = false;
        for(Character c:char2cnt.keySet()){
            int cnt = char2cnt.get(c);
            LinkedList<Integer> indices = char2indices.get(c);
            for(int i = 0; i < cnt; i++) {
                if(indices.isEmpty()){
                    fail = true;
                    break;
                } else {
                    int index = indices.removeFirst();
                    window.get(c).add(index);
                    if(left > index) {
                        left = index;
                    } 
                    if(right < index) {
                        right = index;
                    }
                }
            }
            if(fail)    break;
        }
        
        if(fail)    return "";
        
        int min = right - left + 1;
        String res = s.substring(left, right + 1);
        while(true) { 
            char c = s.charAt(left);
            if(char2indices.get(c).isEmpty()){
                break;
            }
            window.get(c).remove(0);
            int index = char2indices.get(c).removeFirst();
            window.get(c).add(index);
            if(index > right) {
                right = index;
            }
            left = index;
            for(Character ch:window.keySet()){
                if(left > window.get(ch).get(0)) {
                    left = window.get(ch).get(0);
                }
            }
            if(min > right - left + 1) {
                min = right - left + 1;
                res = s.substring(left, right + 1);
            }
        } 
        return res;
    } 
}
 
/*
Submission Result: Wrong Answer More Details 

Input:
"bdab"
"ab"
Output:
"bda"
Expected:
"ab"
*/
