public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        
        for(int i:nums) {
            if(i % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }
         
        
        int base = -(n+1)/2;
        if(n % 2 == 0) {
            base += n;
        } 
        
        int ret = base - sum;
        if(ret < 0) {
            return -ret;
        }
        return ret;
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
