public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return 0.0;
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int hi1 = len1 - 1;
        int hi2 = len2 - 1;
        
        int len = len1 + len2;
        int mid = len / 2;
        
        if(len % 2 == 1) {
            return findKth(nums1, nums2, 0, hi1, 0, hi2, mid);
        } else {
            return (findKth(nums1, nums2, 0, hi1, 0, hi2, mid) + findKth(nums1, nums2, 0, hi1, 0, hi2, mid - 1))*0.5;
        }
    }
    
    private int findKth(int[] nums1, int[] nums2, int lo1, int hi1, int lo2, int hi2, int k) {
        if(lo1 > hi1) {
            return nums2[lo2 + k];
        } 
        
        if(lo2 > hi2) {
            return nums1[lo1 + k];
        }
        
        if(k == 0) {
            return Math.min(nums1[lo1], nums2[lo2]);
        }
        
        int len1 = hi1 - lo1 + 1;
        int len2 = hi2 - lo2 + 1;
        
        int subLen1 = k*len1/(len1 + len2);
        int subLen2 = k - 1 - subLen1;
        
        int idx1 = lo1 + subLen1;
        int idx2 = lo2 + subLen2;
        
        if(nums1[idx1] < nums2[idx2]) {
            lo1 = idx1 + 1;
            hi2 = idx2;
            k -= (subLen1 + 1);
        } else {
            lo2 = idx2 + 1;
            hi1 = idx1;
            k -= (subLen2 + 1);
        }
        
        return findKth(nums1, nums2, lo1, hi1, lo2, hi2, k);
        
    }
}
