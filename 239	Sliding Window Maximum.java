public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k == 0) { 
            return (new int[k]);
        }
        int len = nums.length;
        
        int[] res = new int[len - k + 1];
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        if(len < k) {
            /* */
        }
        
        for(int i = 0; i < k; i++) {
            addIn(list, nums[i]);
        }
        res[0] = list.get(0);
        
        for(int i = k; i < len; i++) {
            if(nums[i-k] == list.get(0)){
                list.removeFirst();
            }
            addIn(list, nums[i]);
            res[i-k+1] = list.get(0);
        }
        return res;
        
    }
    
    private void addIn(LinkedList<Integer> list, int val) {
        while(!list.isEmpty() && list.get(list.size()-1) < val) { 
            list.removeLast();
        }
        list.add(val);
    }
}
