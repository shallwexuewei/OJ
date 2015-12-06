public class NumArray {
    int[] sums;
    
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        sums = new int[len];
        sums[0] = nums[0];
        for(int i = 1; i < len; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(sums == null) {
            return 0;
        }
        if(i < 0 || j >= sums.length) {
            return 0;
        }
        if(i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i-1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

/*
 Runtime Error More Details 

Last executed input:
[-2,0,3,-5,2,-1],sumRange(0,2),sumRange(2,5),sumRange(0,5)

 Runtime Error More Details 

Last executed input:
[]
*/
