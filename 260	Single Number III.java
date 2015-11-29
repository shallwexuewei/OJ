public class Solution {
    public int[] singleNumber(int[] nums) {
        // pass 1: get xor of the two nums:
        int xor2 = 0;
        for(int i:nums) {
            xor2 ^= i;
        }
        
        // get last set bit:
        int mask = xor2 & (-xor2);
        
        // pass 2: group nums by mask and xor them separately 
        int ret[] = {0, 0};
        
        for(int i:nums) {
            if((i&mask) == 0) {
                ret[0] ^= i;
            } else {
                ret[1] ^= i;
            }
        }
        
        return ret;
    }
}

/*
Wrong Answer More Details 

Input:
[2,1,2,3,4,1]
Output:
[0,7]
Expected:
[3,4]
*/
