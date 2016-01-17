public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0)    return 0;
        
        int cnt = len;
        for(int i = 0; i < len; i++, cnt--) {
            if(citations[i] >= cnt) {
                return cnt;
            }
        }
        return 0;
    }
}
