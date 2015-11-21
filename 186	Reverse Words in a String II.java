public class Solution {
   
    public void reverseWords(char[] s) {
        if(s == null) return;
        
        reverse(s, 0, s.length - 1); 
        
        int start = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                reverse(s, start, i-1);
                start = i + 1;
            } 
        }
        reverse(s, start, s.length - 1); 
    }
    
    private void reverse(char[] s, int start, int end) {
        int mid = (end - start + 1)/2;
        for(int i = 0; i < mid; i++) {
            swap(s, start + i, end - i);
        }
    }
    
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
     
}

/*
Wrong Answer More Details 

Input:
"hello world!"
Output:
"orld! hellow"
Expected:
"world! hello"
*/
