public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        sums[0] = 0;
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        System.out.println(Arrays.toString(sums));
            
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
        int count = 0;
        
        // use two pointer to narrow down the window
        int left = mid + 1;
        int right = left;
        int auxI = left;
        int sumsI = lo;
        
        // merge all values in the left part back to sums
        for(int k = lo; k <= mid; k++) {
            // find left boundary
            while(left <= hi && aux[left] - aux[k] < lower) {
                left++;
            }
            // find right boudary
            while(right <= hi && aux[right] - aux[k] <= upper) {
                right++;
            } 
            // real merge sort
            while(auxI <= hi && aux[auxI] < aux[k]) {
                sums[sumsI++] = aux[auxI++];
            }
            sums[sumsI++] = aux[k];
            count += right - left;
        }
        
        return count;
    }
}
