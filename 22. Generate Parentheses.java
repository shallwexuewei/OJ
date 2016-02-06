public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n < 1)   return result;
        
        generateParenthesis(new StringBuilder(2*n), 0, 2*n, result);
        return result;
    }
    
    private void generateParenthesis(StringBuilder builder, int numLeft, int rest, List<String> result) {
        if(rest == 0) {
            result.add(builder.toString());
            return;
        }
        if(numLeft == rest) {
            for(int i = 0; i < rest; i++) {
                builder.append(')');
            }
            result.add(builder.toString());
            return;
        }
        
        int len = builder.length();
        if(numLeft < rest) {
            builder.append('(');
            generateParenthesis(builder, numLeft + 1, rest - 1, result);
        }
        builder.setLength(len);
        if(numLeft > 0) {
            builder.append(')');
            generateParenthesis(builder, numLeft - 1, rest - 1, result);
        }
        
        builder.setLength(len);
    }
}
