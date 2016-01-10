public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len == 0)    return 0;
        
        int[] dict = new int[256]; // exteneded ascii
        
        int cnt = 0;
        int max = -1;
        int st = 0;
        
        for(int i = 0; i < len; i++) {
            int charI = (int) s.charAt(i);
            dict[charI]++;
            if(dict[charI] == 1) {
                cnt++;
                // new char
                while(cnt > 2) {
                    int stI = (int) s.charAt(st);
                    dict[stI]--;
                    if(dict[stI] == 0) {
                        cnt--;
                    }
                    st++;
                }
            }
            if(i - st + 1 > max) {
                max = i - st + 1;
            }
        }
        return max;
        
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"abc"
Output:
3
Expected:
2
*/
