public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int sum2 = nums[i] + nums[j];
                for(int k = j + 1; k < len; k++) {
                    int sum3 = sum2 + nums[k];
                    if(sum3 < target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
