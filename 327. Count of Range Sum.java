public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if(lower > upper || upper > len - 1) {
            return 0;
        }
        
        int count = 0;
        for(int i = 0; i < len; i++) {
            int sum = 0;
            for(int j = i; j < len; j++) {
                sum += nums[j];
                if(sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}
