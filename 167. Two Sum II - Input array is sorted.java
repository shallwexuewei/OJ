public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return null;
        }
        
        int lo = 0;
        int hi = numbers.length - 1;
        int mid = hi/2;
        while(mid > 0 && numbers[mid] > target) {
            hi = mid;
            mid = hi/2;
        }
        
        while(lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if(sum < target) {
                lo++;
            } else if(sum > target) {
                hi--;
            } else {
                return new int[] {lo+1, hi+1};
            }
        }
        return new int[] {-1, -1};
    }
}
