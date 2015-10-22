public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] cs = character2num(s);
        int[] ct = character2num(t);
        
        HashMap<Integer, Integer> num2cnt = new HashMap<Integer, Integer>();
        for(int i = 0; i < 52; i++) {
            if(cs[i] != 0){
                if(num2cnt.containsKey(cs[i])){
                    num2cnt.put(cs[i], num2cnt.get(cs[i]) + 1);
                } else {
                    num2cnt.put(cs[i], 1);
                }
            }
        }
        
        for(int i = 0; i < 52; i++) {
            if(ct[i] != 0){
                if(num2cnt.containsKey(ct[i])){
                    if(num2cnt.get(ct[i]) == 1) {
                        num2cnt.remove(ct[i]);
                    } else{
                        num2cnt.put(ct[i], num2cnt.get(ct[i])-1);
                    }
                    
                }else {
                    return false;
                }
            }
        }
        if(num2cnt.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    public int[] character2num(String s) {
        int[] c = new int[52];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a'){
                c[s.charAt(i) - 'a']++;
            }
            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A'){
                c[s.charAt(i) - 'A']++;
            }
        }
        return c;
        
    }
}
