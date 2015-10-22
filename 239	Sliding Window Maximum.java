public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len < 1 || k < 1) {
            return new int[0];
        }
        if(k == 1) {
            return nums;
        }
        
        int winLen = len - k + 1;
        int[] winMax = new int[winLen];
        
        LinkedList<Integer> maxList = new LinkedList<Integer>();
        
        maxList.add(nums[0]);
        
        for(int i = 1; i < len; i++) {
            if(nums[i] > maxList.get(0)) {
                maxList.clear();
                maxList.add(nums[i]);
            } else{
                while(maxList.get(maxList.size()-1) < nums[i]){
                    maxList.removeLast();
                }
                maxList.add(nums[i]);
            }
            if(i >= k) {
                int deleted = i - k;
                if(maxList.size() > 1 && maxList.get(0) == nums[deleted]){
                    maxList.remove();
                }
                winMax[i-k+1] = maxList.get(0);
            } else if(i == k-1) {
                winMax[i-k+1] = maxList.get(0);
            }
        }
        
        return winMax;
        
    }
}
