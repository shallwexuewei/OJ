public class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        int carry = 1;
        int len = digits.length;
        
        for(int i = len - 1; i > -1; i--) {
            int sum = carry + digits[i];
            if(sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                if(carry == 1) {
                    carry = 0;
                }
            }
            nums.add(sum);
        }
        
        if(carry == 1) {
            len++;
            nums.add(carry);
        }
        
        int[] r = new int[len];
        int i = 0;
        while(nums.isEmpty() == false){
            r[i] = nums.removeLast();
            i++;
        }
        return r;
    }
}
