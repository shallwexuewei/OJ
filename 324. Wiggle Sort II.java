public class Solution {
    public void wiggleSort(int[] nums) {
        int[] array = Arrays.copyOf(nums, nums.length); 
        Arrays.sort(array);
        int mid = nums.length % 2 == 0 ? nums.length / 2 - 1: nums.length / 2;
        
        for (int i = 0; i < nums.length; i = i + 2) {
            int halfI = i/2;
            nums[i] = array[mid - halfI];
            if (i + 1 < nums.length) {
                nums[i + 1] = array[array.length - 1 - halfI];
            }
        }
        
    }
}



/*
Submission Result: Wrong Answer More Details 

Input:
[1,2,2,1,2,1,1,1,1,2,2,2]
Output:
[1,2,1,2,1,2,1,1,1,2,2,2]
*/
