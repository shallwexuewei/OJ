public class Solution {
    private String shiftString(String s) {
        int len = s.length();
        if(len == 1)            return "a";
        
        if(s.charAt(0) == 'a')  return s;
        
        int shift = s.charAt(0) - 'a';
        char[] newChars = new char[len];
        
        int lo = 'a';
        int hi = 'z';
        for(int i = 0; i < len; i++) {
            int newCharI = s.charAt(i) - shift;
            if(newCharI < lo) {
                newCharI += 26;
            }
            newChars[i] = (char) newCharI;
        }
        return new String(newChars);
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        int len = strings.length;
        List<List<String>> res = new ArrayList<List<String>>();
        if(len == 0)    return res;
        
        HashMap<String, List<String>> shiftGroup = new HashMap<String, List<String>>();
        for(String s:strings) {
            String shifted = shiftString(s);
            if(shiftGroup.containsKey(shifted)){
                shiftGroup.get(shifted).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                shiftGroup.put(shifted, list);
            }
        }
        
        for(String s:shiftGroup.keySet()){
            Collections.sort(shiftGroup.get(s));
            res.add(shiftGroup.get(s));
        }
        return res;
    }
}

/*
Input:
["az","yx"]
Output:
[["az"],["yx"]]
Expected:
[["az","yx"]]
*/
