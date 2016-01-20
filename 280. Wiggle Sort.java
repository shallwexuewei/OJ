public class Solution {
    public void wiggleSort(int[] nums) {
        boolean up = true;
        for(int i = 1; i < nums.length; i++) {
            if((nums[i] > nums[i-1]) != up) { 
                exch(nums, i, i-1);
            }
            up = !up;
        }
    }
    
    private void exch(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}
