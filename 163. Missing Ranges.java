public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            result.add(getStr(lower, upper));
            return result;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= lower) {
            } else {
                result.add(getStr(lower, Math.min(upper, nums[i] - 1)));
            }
            lower = nums[i] + 1;
        }
        if(lower <= upper) {
            result.add(getStr(lower, upper));
        }
        return result;
    }
    
    private String getStr(int lo, int hi) {
        if(lo == hi)    return lo + "";
        else            return lo + "->" + hi;
    }
}
