public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null) return false;
        return search(nums, target, 0, nums.length - 1);
    }
    
    private boolean search(int[] nums, int target, int low, int high) {
        if(low > high) return false;
        
        int mid = low + (high - low) / 2;
        if(target == nums[mid]) return true;
        
        if(nums[high] > nums[mid]) {
            // right part is normal
            if(target > nums[mid] && target <= nums[high]) {
                return search(nums, target, mid + 1, high);
            } else {
                return search(nums, target, low, mid - 1);
            }
        } else if(nums[low] < nums[mid]) {
            if(target < nums[mid] && target >= nums[low]) {
                return search(nums, target, low, mid - 1);
            } else {
                return search(nums, target, mid + 1, high);
            }
        } else {
            return search(nums, target, low, mid - 1) || search(nums, target, mid + 1, high);
        }
    }
}
