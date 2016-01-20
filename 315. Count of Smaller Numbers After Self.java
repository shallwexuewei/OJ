public class Solution {
    class NumberIndex {
        int number;
        int index;
    
        NumberIndex(int number, int index) {
            this.number = number;
            this.index = index;
        }
    
        NumberIndex(NumberIndex another) {
            this.number = another.number;
            this.index = another.index;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        NumberIndex[] cnums = new NumberIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnums[i] = new NumberIndex(nums[i], i);
        }
        int[] smaller = new int[nums.length];
        NumberIndex[] aux = new NumberIndex[nums.length];
        
        sort(cnums, aux, 0, nums.length - 1, smaller);
        List<Integer> res = new ArrayList<>();
        for (int i : smaller) {
            res.add(i);
        }
        return res;
    }
    
    private void sort(NumberIndex[] nums, NumberIndex[] aux, int lo, int hi, int[] smaller) {
        if(hi <= lo)    return;
        int mid = lo + (hi - lo)/2;
        sort(nums, aux, mid + 1, hi, smaller);
        sort(nums, aux, lo, mid, smaller);
        merge(nums, aux, lo, mid, hi, smaller);
    }
    
    private void merge(NumberIndex[] nums, NumberIndex[] aux, int lo, int mid, int hi, int[] smaller) {
        // copy to aux[]
        for(int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        
        // merge back to nums[]
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if(j > hi ) {
                nums[k] = aux[i];
                smaller[aux[i].index] += j - mid - 1;
                i++;
            } else if(aux[j].number < aux[i].number) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i];
                smaller[aux[i].index] += j - mid - 1;
                i++;
            }
        }
    }
}
