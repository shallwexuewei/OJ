public class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int len = nums.length;
        sums = new int[len+1];
        sums[0] = 0;
        for(int i = 0; i < len; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
