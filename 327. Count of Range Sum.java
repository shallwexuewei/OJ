public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // produce an array sums[i] storing the sum of nums[0:i-1]
        // sums[0] is the sum of nothing, so the length of array sum is n + 1.
        long[] sums = new long[n + 1];
        sums[0] = 0;
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        // System.out.println(Arrays.toString(sums));
        
        // merge sort needs auxiliary array to store the intermediate result    
        long[] aux = new long[n+1];
        return sort(sums, aux, 0, n, lower, upper);
    }
    
    private int sort(long[] sums, long[] aux, int lo, int hi, int lower, int upper) {
        if(hi <= lo)    return 0;
        int mid = lo + (hi - lo)/2;
        int count = 0;
        count += sort(sums, aux, lo, mid, lower, upper);
        count += sort(sums, aux, mid + 1, hi, lower, upper);
        count += merge(sums, aux, lo, mid, hi, lower, upper);
        return count;
    }
    
    private int merge(long[] sums, long[] aux, int lo, int mid, int hi, int lower, int upper) {
        // copy to aux[]
        for(int k = lo; k <= hi; k++) {
            aux[k] = sums[k];
        }
        
        // merge back to sums[]
        // use two pointer to narrow down the window
        int count = 0;
        
        // left, right, aux指针都在右边区间
        int left = mid + 1;
        //int right = left;
        int auxI = left;
        
        // sumI， k指针在左边区间
        int sumsI = lo;
        
        // merge all values in the left part back to sums
        for(int k = lo; k <= mid; k++) {
            // find left boundary
            while(left <= hi && aux[left] - aux[k] < lower) {
                left++;
            }
            // find right boudary
            int right = left;
            while(right <= hi && aux[right] - aux[k] <= upper) {
                right++;
            } 
            
            // real merge sort, 把所有比aux[k]小的右边区间的数都放进sums里
            // 然后再把aux[k]放进sums里。
            while(auxI <= hi && aux[auxI] < aux[k]) {
                sums[sumsI++] = aux[auxI++];
            }
            sums[sumsI++] = aux[k];
            
            // 为什么不用＋1？因为right的值是在窗口外的。
            count += right - left;
        }
        
        return count;
    }
}
