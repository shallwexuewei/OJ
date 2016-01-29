public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // solution 1: merge: O(N) space: O(N)
        // solution 2: find kth in nums and nums2
        int[] nums;
        if(checkArray(nums1) == false ) {
            if(checkArray(nums2) == false) {
                return 0.0;
            } else {
                return findMedian(nums2);
            }
        }
        if(checkArray(nums2) == false) {
            return findMedian(nums1);
        } 
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int half = len/2;
        int last1 = len1 - 1;
        int last2 = len2 - 1;
        if(len%2 == 1) {
            return findKth(nums1, nums2, 0, last1, 0, last2, half);
        } else {
            return (findKth(nums1, nums2, 0, last1, 0, last2, half)+findKth(nums1, nums2, 0, last1, 0, last2, half-1))*0.5;
        }
    }
    
    private boolean checkArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        return true;
    }
    
    private double findMedian(int[] nums) {
        int len = nums.length;
        int half = len/2;
        if(len%2 == 1) {
            return nums[half];
        } else {
            return (nums[half] + nums[half-1])*0.5;
        }
    }
    
    private int findKth(int[] nums1, int[] nums2, int lo1, int hi1, 
                            int lo2, int hi2, int k) {
                     
        if(lo1 > hi1) {
            return nums2[lo2+k];
        } else if(lo2 > hi2) {
            return nums1[lo1+k];
        } 
           
        if(k == 0) {
            return Math.min(nums1[lo1], nums2[lo2]);
        } 
        
        int len1 = hi1-lo1+1;
        int len2 = hi2-lo2+1;
        int len = len1 + len2;
        
        int k1 = k * len1/len;
        int k2 = k - 1 - k1;
        
        int i1 = k1 + lo1;
        int i2 = k2 + lo2;
        if(nums1[i1] < nums2[i2]) {
            k -= k1 + 1;
            return findKth(nums1, nums2, lo1+k1+1, hi1, lo2, hi2, k);
        } else {
            k -= k2 + 1;
            return findKth(nums1, nums2, lo1, hi1, lo2+k2+1, hi2, k);
        }
    }
}
/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 69: java.lang.ArrayIndexOutOfBoundsException: 1
Last executed input:
[2,3,4]
[1]

Submission Result: Wrong Answer More Details 

Input:
[1,2]
[1,2]
Output:
2.00000
Expected:
1.50000
*/
