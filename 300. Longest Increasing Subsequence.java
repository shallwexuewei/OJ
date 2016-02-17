public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int maxLen = 0;
        for(int i = 0; i < len; i++) {
            int subLen = 1;
            int prev = nums[i];
            int prevPrev = nums[i];
            for(int j = i + 1; j < len; j++) {
                if(nums[j] > prev) {
                    subLen++;
                    prevPrev = prev;
                    prev = nums[j];
                } else {
                    if(nums[j] > prevPrev) {
                        prev = nums[j];
                    }
                }
            }
            if(subLen > maxLen) {
                maxLen = subLen;
            }
        }
        return maxLen;
    }
}
