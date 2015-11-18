public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> char2cnt = new HashMap<Character, Integer>();
        int len = s.length(); 
        int last = 0;
        int max = 0; 
        for(int i = 0; i < len; i++) {
            if(char2cnt.containsKey(s.charAt(i))){
                char2cnt.put(s.charAt(i), char2cnt.get(s.charAt(i))+1);
            } else {
                char2cnt.put(s.charAt(i), 1);
                while(char2cnt.keySet().size() > 2){
                    char2cnt.put(s.charAt(last), char2cnt.get(s.charAt(last))-1);
                    if(char2cnt.get(s.charAt(last)) == 0){
                        char2cnt.remove(s.charAt(last));
                    }
                    last++;
                } 
            }
            max = Math.max(max, i-last+1);
        }
        return max;
    }
}

/*

Input:
"abaccc"
Output:
5
Expected:
4

Input:
"a"
Output:
0
Expected:
1
*/
