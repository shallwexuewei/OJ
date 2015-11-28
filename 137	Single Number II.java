public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i:nums) {
            if(map.containsKey(i)){
                int val = map.get(i);
                if(val == 2) {
                    map.remove(i);
                } else {
                    map.put(i, val+1);
                }
            } else {
                map.put(i, 1);
            }
        }
        
        for(Integer key:map.keySet()){
            if(map.get(key) == 1) {
                return key;
            }
            
            
        }
        
        return -1;
    }
}
