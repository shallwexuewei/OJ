public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] nums = new int[len + 1];
        
        
        for(int c:citations) {
            if(c > len) {
                nums[len]++;
            } else {
                nums[c]++;
            }
        }
        
        if(nums[len] >= len) {
            return len;
        }
        for(int i = len-1; i > -1; i--) {
            nums[i] += nums[i+1];
            if(nums[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
