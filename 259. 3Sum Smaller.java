public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            int sumTarget = target - nums[i];
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                if(nums[left] + nums[right] >= sumTarget) {
                    right --;
                } else {
                    count += right - left;
                    left++;
                }
            }
        }
        return count;
    }
}
