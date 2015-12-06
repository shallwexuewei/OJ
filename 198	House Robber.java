public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length== 0) {
            return 0;
        }
        
        int[] sum = nums.clone();
        int len = nums.length;
        
        if(len == 1) {
            return nums[0];
        } else if(len == 2) {
            return Math.max(nums[0], nums[1]);
        } else if(len == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        
        sum[2] += sum[0];
        for(int i = 3; i < nums.length; i++) {
            sum[i] = Math.max(sum[i-3], sum[i-2]) + nums[i];
        }
        return Math.max(sum[len-1], sum[len-2]);
    }
}
