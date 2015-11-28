public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:nums) {
            if(set.contains(i)){
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
