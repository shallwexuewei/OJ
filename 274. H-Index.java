public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  {
            // ...
        }
        
        Arrays.sort(citations);
        
        int len = citations.length;
        int cnt = len;
        for(int i = 0; i < len; i++, cnt--) {
            if(citations[i] >= cnt) {
                return cnt;
            }
        }
        return 0;
    }
}
