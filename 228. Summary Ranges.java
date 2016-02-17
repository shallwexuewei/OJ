public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<String>();
        if(nums == null || nums.length < 1) {
            return result;
        }
        int lower = nums[0];
        int i = 1;
        while(i < nums.length) {
            if(nums[i] == nums[i-1] + 1) {
            } else {
                result.add(getStr(lower, nums[i-1]));
                lower = nums[i];
            }
            i++;
        }
        result.add(getStr(lower, nums[i-1]));
        return result;
    }
    
    private String getStr(int lower, int upper) {
        if(lower == upper) return "" + lower;
        else    return lower + "->" + upper;
    }
}
