public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] lefts = {'(', '{', '['};
        char[] rights = {')', '}', ']'};
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isLeft = false;
            for(int j = 0; j < 3; j++) {
                if(lefts[j] == c) {
                    stack.push(c);
                    isLeft = true;
                    break;
                }
            }
            if(isLeft)  continue;
            
            for(int j = 0; j < 3; j++) {
                if(rights[j] == c) {
                    if(stack.isEmpty() || stack.pop() != lefts[j]) {
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
