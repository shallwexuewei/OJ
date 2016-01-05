public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null) return 0;
        
        int len = ratings.length;
        if(len < 1)         return 0;
        
        int[] nums = new int[len];
        Arrays.fill(nums, 1);
        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]) {
                nums[i] = nums[i-1] + 1;
            }
        }
        
        // round 2, right to left
        for(int i = len - 2; i > -1; i--) {
            if(ratings[i] > ratings[i+1]) {
                nums[i] = Math.max(nums[i], nums[i+1] + 1);
            }
        }
        
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
