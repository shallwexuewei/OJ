public class Solution {
    public int missingNumber(int[] nums) { //xor
        int res = nums.length; // note that the default value of res is nums.length!!!
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}

/*
Your input

[0]
Your answer

0
Expected answer

1
*/
