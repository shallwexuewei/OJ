public class Solution {
    
    public int evalRPN(String[] tokens) {
        // use stack
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int len = tokens.length;
        for(int i = 0; i < len; i++) {
            if(tokens[i].compareTo("+") == 0) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.add(a + b);
            } else if(tokens[i].compareTo("-") == 0) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.add(b - a);
            } else if(tokens[i].compareTo("*") == 0) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.add(a * b);
            } else if(tokens[i].compareTo("/") == 0) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.add(b / a);
            } else {
                int val = Integer.parseInt(tokens[i]);
                stack.add(val);
            }
        }
        return stack.removeLast();
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 23: java.lang.ArithmeticException: / by zero
Last executed input:
["0","3","/"]
*/
