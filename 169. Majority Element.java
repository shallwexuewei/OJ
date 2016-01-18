public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        boolean found = false;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!found) {
                candidate = nums[i];
                count++;
                found = true;
            } else {
                if(candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                    if(count == 0) {
                        found = false;
                    }
                }
            }
        }
        
        return candidate;
    }
}
