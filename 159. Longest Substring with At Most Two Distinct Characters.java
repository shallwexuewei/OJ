public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] counts = new int[256];
        
        int len = s.length();
        if(len < 3) {
            return len;
        }
        
        counts[s.charAt(0)]++;
        int distNum = 1;
        int max = 0;
        
        // left pointer points to index 0
        int left = 0;
        for(int right = 1; right < len; right++) {
            char rightChar = s.charAt(right);
            counts[rightChar]++;
            if(counts[rightChar] == 1) {
                if(distNum < 2) {
                    distNum++;
                } else {
                    char leftChar = s.charAt(left);
                    while(counts[leftChar] > 0) {
                        leftChar = s.charAt(left);
                        counts[leftChar]--;
                        left++;
                    }
                }
            }
            
            int winLen = right - left + 1;
            if(winLen > max) {
                max = winLen;
            }
        }
        
        return max;
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 25: java.lang.StringIndexOutOfBoundsException: String index out of range: 3
Last executed input:
"abc"
*/
