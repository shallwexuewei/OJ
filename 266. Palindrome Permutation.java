public class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] odd = new boolean[256];
        int oddNum = 0;
        for(int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i);
            if(odd[charIdx]) {
                oddNum--;
                odd[charIdx] = false;
            } else {
                oddNum++;
                odd[charIdx] = true;
            }
        }
        
        return oddNum < 2;
    }
}
