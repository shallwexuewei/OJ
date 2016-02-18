public class Solution {
    private char[][] num2chars = { {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n','o'},
    {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.isEmpty()) {
            return result;
        }
        
        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void dfs(String digits, int depth, StringBuilder builder, List<String> result) {
        if(depth == digits.length()){
            result.add(builder.toString());
            return;
        }
        
        int digit = digits.charAt(depth) - '0';
        char[] chars = num2chars[digit];
        for(int j = 0; j < chars.length; j++) {
            builder.append(chars[j]);
            dfs(digits, depth + 1, builder, result);
            builder.setLength(builder.length() - 1);
        }
    }
}
