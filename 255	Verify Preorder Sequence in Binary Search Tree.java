public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null) {
            return false;
        }
        
        int len = preorder.length;
        if(len < 2) {
            return true;
        }
        
        int min = Integer.MIN_VALUE; 
        
        int i = 1;
        Stack<Integer> ancestors = new Stack<Integer>();
        ancestors.add(preorder[0]);
        while(i < len) {
            // exception:
            if(preorder[i] < min) {
                return false;
            }
            // left subtree:
            else if(preorder[i] < ancestors.peek()){
                // push a new parent
                ancestors.push(preorder[i]);
            }
            // or preorder[i] >= ancestors.peek() 
            else{
                // right subtree
                min = ancestors.pop();
                // actually ancestor's right subtree 
                // rather than current parent's right subtree
                while(!ancestors.empty() && preorder[i] > ancestors.peek()){
                    min = ancestors.pop();
                }
                ancestors.push(preorder[i]);
            }
            
            i++;
        }
        
        return true;
    }
    
}

/*
Runtime Error More Details 

Runtime Error Message:
Line 21: java.util.EmptyStackException
Last executed input:
[1,2,3]


Wrong Answer More Details 

Input:
[3,1,4,2]
Output:
true
Expected:
false


 Wrong Answer More Details 

Input:
[4,2,3,1]
Output:
true
Expected:
false
 
*/
