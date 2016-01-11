public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return 0;
        
        int len = nums.length;
        
        int sum = 0;    // sum of subarray from 0 to i
        int maxLen = 0; // target length
        // sum -> 0 to the left most index that makes the sum 
        HashMap<Integer, Integer> sum2index = new HashMap<Integer, Integer>();
        // Don't forget this!!!
        sum2index.put(0, -1);
        for(int i = 0; i < len; i++) {
            sum += nums[i];
            if(!sum2index.containsKey(sum)){
                sum2index.put(sum, i);
            }
            
            // prevSum + targetWindow = sum, we need to find the end of prevSum
            int prevSum = sum - k;
            if(sum2index.containsKey(prevSum)){
                int winLen = i - sum2index.get(prevSum);
                if(winLen > maxLen ) {
                    maxLen = winLen;
                }
            }
        }
        return maxLen;
    }
}
