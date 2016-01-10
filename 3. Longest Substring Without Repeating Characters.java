public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
        
        int[] dict = new int[256]; // extended ascii
        
        int st = 0;
        int max = -1; // max len of window 
        
        // window: double pointers
        for(int i = 0; i < len; i++) {
            int ci = (int) s.charAt(i);
            dict[ci]++;
            
            if(dict[ci] > 1) {
                // existed
                while(true) {
                    int stI = (int) s.charAt(st);
                    dict[stI]--;
                    st++;
                    if(stI == ci) {
                        break;
                    }
                }
                
            }
            
            if(max < i - st + 1) {
                max = i - st + 1;
            }
        }
        return max;
    }
}
