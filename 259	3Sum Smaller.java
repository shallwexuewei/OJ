public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if(len < 3) {
            return 0;
        }
        int cnt = 0;
        for(int i = 0; i < len - 2; i++) {
            for(int j = i+1; j < len - 1; j++) {
                for(int k = j+1; k < len; k++) {
                    if(nums[i] + nums[j] + nums[k] < target) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
