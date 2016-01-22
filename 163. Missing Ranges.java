public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        
        List<String> result = new ArrayList<String>();
        if(len == 0) {
            result.add(interval2string(lower, upper));
            return result;
        }
        
        int i = 0;
        while(i < len && nums[i] < lower) {
            i++;
        }
        
        // now nums[i] == lower or > lower or i == len
        if(i == len || nums[i] > upper) {
            result.add(interval2string(lower, upper));
            return result;
        }
        
        if(nums[i] > lower) {
            result.add(interval2string(lower, nums[i]-1));
        }
        
        i++;
        while(i < len) {
            if(nums[i] > upper) {
                break;
            }
            if(nums[i] != nums[i-1]+1) {
                result.add(interval2string(nums[i-1]+1, nums[i]-1));
            }
            i++;
        }
        
        if(nums[i-1] < upper) {
            result.add(interval2string(nums[i-1]+1, upper));
        }
        
        return result;
    }
    
    private String interval2string(int lo, int hi) {
        if(lo == hi)    return ""+lo;
        else            return lo + "->" + hi;
    }
}
