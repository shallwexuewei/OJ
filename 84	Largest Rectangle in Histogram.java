public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null) {
            return 0;
        }
        
        int len = height.length;
        if(len == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i < len) {
            if(stack.empty() || height[stack.peek()] < height[i]){
                stack.push(i);
                i++;
            } else {
                int position = stack.pop();
                int width = stack.empty() ? i:i - 1 - stack.peek();
                max = Math.max(max, width* height[position]);
            }
        }
        
        while(stack.empty() == false){ 
                int position = stack.pop();
                int width = stack.empty() ? i:i - 1 - stack.peek();
                max = Math.max(max, width* height[position]);
        }
        
        return max;
    }
}

/*
Your input

[]
Your answer

-2147483648
Expected answer

0

forget i++:
Time Limit Exceeded More Details 

Last executed input:
[0]

Wrong Answer More Details 

Input:
[0]
Output:
-2147483648
Expected:
0


width shouldn't be position-start+1, but i-1-stack.peek()
Wrong Answer More Details 

Input:
[1]
Output:
0
Expected:
1
*/
