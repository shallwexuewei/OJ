public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesis(new StringBuilder(), n, 0, result);
        return result;
    }
    
    private void generateParenthesis(StringBuilder builder, int leftLeft, int rightLeft, List<String> result) {
        if(leftLeft == 0 && rightLeft == 0)   {
            result.add(builder.toString());
            return;
        }
        
        if(leftLeft > 0) {
            builder.append('(');
            generateParenthesis(builder, leftLeft - 1, rightLeft + 1, result);
            builder.setLength(builder.length() - 1);
        } 
        if(rightLeft > 0) {
            builder.append(')');
            generateParenthesis(builder, leftLeft, rightLeft - 1, result);
            builder.setLength(builder.length() - 1);
        }
    }
}
