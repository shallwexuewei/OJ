public class Solution {
    public boolean canPermutePalindrome(String s) {
        int len = s.length();
        if(len < 1) {
            return false;
        }
        
        int[] counts = new int[256]; // extended ASII
        int oddNum = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            counts[c]++;
            if(counts[c] % 2 == 0) {
                oddNum--;
            } else {
                oddNum++;
            }
        }
        
        if(oddNum <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
