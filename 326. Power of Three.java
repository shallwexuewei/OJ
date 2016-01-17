public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) {
            return true;
        } else if(n < 3) {
            return false;
        }
        if(n%3 != 0) {
            return false;
        }
        
        return isPowerOfThree(n/3);
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
1
Output:
false
Expected:
true
*/
