public class Solution {
    public int calculate(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> numStack = new Stack<Integer>();
        
        s = s.trim().replaceAll(" ", "");
        int len = s.length();
        for(int i = 0; i < len; ) {
            if(isNumber(s.charAt(i))) {
                int start = i;
                i++;
                while(i < len && isNumber(s.charAt(i))) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(start, i));
                
                if(!stack.isEmpty() && stack.peek() != '(') {
                    num = operate(stack.pop(), numStack.pop(), num);
                }
                
                numStack.push(num);
                
            }
            
            if(i < len) {
                if(s.charAt(i) == ')') {
                    if(stack.peek() == '('){
                        stack.pop();
                        if(!stack.isEmpty() && stack.peek() != '(' )
                        {
                            int last = numStack.pop();
                            while(!stack.isEmpty() && stack.peek() != '(') {
                                last = operate(stack.pop(), numStack.pop(), last);
                            }
                            numStack.push(last);
                        }
                    } else {
                        // throw ..exception
                    }
                } else {
                    stack.push(s.charAt(i));
                }
                i++;
            }
        }
        
        return numStack.pop();
        
    }
    
    private int operate(char c, int num1, int num2) {
        if(c == '+') {
            return num1 + num2;
        }
        if(c == '-') {
            return num1 - num2;
        }
        // throws ... exception
        return num1;
    }
    
    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"2147483647"
Output:
2
Expected:
2147483647

Submission Result: Wrong Answer More Details 

Input:
"1-(5)"
Output:
5
Expected:
-4
*/
