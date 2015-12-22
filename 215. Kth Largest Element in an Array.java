public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null)    return -1;
        
        int len = nums.length;
        if(len == 0)        return -1;
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i = 0; i < k && i < len; i++) {
            q.add(nums[i]);
        }
        
        for(int i = k; i < len; i++) {
            q.add(nums[i]);
            q.poll();
        } 
        
        return q.poll();
    }
}
