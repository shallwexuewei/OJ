public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) {
            return -1;
        }
        int len = s.length();
        if(len == -1) {
            return 0;
        }
        
        // use stack to store the positions of '('
        Stack<Integer> stack = new Stack<Integer>();
        
        int maxLen = 0;
        int beforeStart = -1;
        
        // traverse the string and maintain the stack
        // use the positions of '(' to caculate the length of parentheses sequences
        for(int i = 0; i < len; i++) {
            // characters just contain '(' and ')' 
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                // ')'
                if(stack.isEmpty()) {
                    // the previous sequence ended
                    // store the position before the first '(' of next sequence
                    beforeStart = i;
                }
                else {
                    stack.pop(); // pop the position of matched '('
                    if(stack.isEmpty()) {
                        // there maybe continous sequence can be combined
                        // like i = 3 in the example ")()()"
                        maxLen = Math.max(maxLen, i - beforeStart);
                    }
                    else {
                        // like i = 1 in the example "(())"
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
        
    }
}
