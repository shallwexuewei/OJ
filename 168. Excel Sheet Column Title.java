public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            n--;
            int tmp = n%26;
            n /= 26;
            res = (char)('A'+tmp) + res;
        }
        return res;
    }
}
