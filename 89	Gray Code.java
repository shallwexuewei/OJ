public class Solution {
    public List<Integer> grayCode(int n) {
        if(n < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<Integer>(1<<n);
        
        result.add(0);
        if(n == 0) return result;
        
        
        int i = 0;
        while(i < n) {
            int added = 1 << i;
            int size = result.size();
            for(int j = size - 1; j > -1; j--) {
                result.add(added + result.get(j));
            }
            i++;
        }
        
        return result;
    }
}
