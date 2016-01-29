public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // solution 1: merge: O(N) space: O(N)
        // solution 2: find kth in nums and nums2
        int[] nums;
        if(checkArray(nums1) == false ) {
            if(checkArray(nums2) == false) {
                return 0.0;
            } else {
                nums = nums2;
            }
        }
        if(checkArray(nums2) == false) {
            nums = nums1;
        } else {
            nums = merge(nums1, nums2);
        }
        int len = nums.length;
        int half = len/2;
        if(len%2 == 1) {
            return nums[half];
        } else {
            return (nums[half]+nums[half-1])/2.0;
        }
    }
    
    private boolean checkArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        return true;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1+len2];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1 < len1 && i2 < len2) {
            if(nums1[i1] < nums2[i2]) {
                nums[i] = nums1[i1];
                i1++;
            } else {
                nums[i] = nums2[i2];
                i2++;
            }
            i++;
        }
        while(i1 < len1) {
            nums[i] = nums1[i1];
            i++;
            i1++;
        }
        while(i2 < len2) {
            nums[i] = nums2[i2];
            i++;
            i2++;
        }
        return nums;
    }
}
