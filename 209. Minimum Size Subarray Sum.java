public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null)        return 0;
        
        int len = nums.length;
        if(len == 0)            return 0;
        if(nums[0] == s)        return 1; 
         
        int left = 0;
        int right = 0; 
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < nums.length) {
            while(right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }
            if(sum < s) {
                break;
            }
            while(left < right && sum >= s) {
                sum -= nums[left];
                left++;
            }
            if(right - left + 1 < minLen) {
                minLen = right - left + 1;
            }
        }
        if(minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        } 
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 20: java.util.ConcurrentModificationException
Last executed input:
11
[1,2,3,4,5]
*/
