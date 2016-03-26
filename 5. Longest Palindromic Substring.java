public class Solution {
    public boolean isPalindrome(String s, int startIndex, int endIndex) { // 里层循环，时间O(N)
        for(int i = startIndex, j = endIndex; i < j; i++, j--) 
                if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        int longestLen = 0;
        int endIdx = 0;
    
        for(int currentIndex = 0; currentIndex < n; currentIndex++) { // 外层循环，时间O(N)
            if(isPalindrome(s,currentIndex - longestLen, currentIndex)){
                // 为什么只需要判断longestLen＋1的情况？而不用继续向两边拓展？
                // 因为如果当前下标指向的字符能够构成更长的回文的话，必须满足条件：
                // 前面longestLen－1长度的子字符串也是回文
                longestLen += 1;
                endIdx = currentIndex;
            } else if(currentIndex - longestLen - 1 >= 0 && 
                      isPalindrome(s, currentIndex - longestLen - 1, currentIndex)) {
                // 为什么只需要判断longestLen＋2的情况？而不用继续向两边拓展？
                // 因为如果当前下标指向的字符能够构成更长的回文的话，必须满足条件：
                // 前面longestLen长度的子字符串也是回文
                longestLen += 2;
                endIdx = currentIndex;
            }   
        }
        endIdx++;
        return s.substring(endIdx - longestLen, endIdx);
    }
    }
