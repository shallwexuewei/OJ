public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<String>();
        
        if(nums == null || upper < lower)    return result;
        
        int len = nums.length;
        //if(len == 0)    return result;
        if(len == 0) {
            result.add(getStr(lower, upper));
            return result;
        }
        
        int i = 0;
        while(i < len && nums[i] < lower) {
            i++;
        }
        if(i == len)    return result;
        
        /* i < len && nums[i] >= lower */
        if(nums[i] > lower) {
            if(nums[i] > upper) {
                result.add(getStr(lower, upper));
                return result;
            } else {
                result.add(getStr(lower, nums[i]-1));
            }
        } 
        
        int prev = nums[i];
        i++;
        while(i < len && nums[i] <= upper) {
            if(nums[i] != prev + 1) {
                result.add(getStr(prev + 1, nums[i] - 1));
            }
            prev = nums[i];
            i++;
        }
        
        /*
        if(i < len) {
            if(nums[i-1)
        } else {
            // i == len
            if(nums[i-1] < upper) {
                result.add(getStr(nums[i-1] + 1, upper));
            }
        }*/
        
        
            if(nums[i-1] < upper) {
                result.add(getStr(nums[i-1] + 1, upper));
            }
        
        return result;
    }
    
    private String getStr(int lower, int upper) {
        if(lower == upper) return "" + lower;
        else    return lower + "->" + upper;
    }
}

/*
null

Input:
[]
1
1
Output:
[]
Expected:
["1"]
*/
