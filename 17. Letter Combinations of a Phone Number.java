public class Solution {
    private char[][] num2chars = { {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n','o'},
    {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.isEmpty()) {
            return result;
        }
        
        ArrayList<StringBuilder> builders = new ArrayList<StringBuilder>();
        for(int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            if(digit < 2 || digit > 9) {
                // throw
                return result;
            }
            
            char[] chars = num2chars[digit];
            ArrayList<StringBuilder> newBuilders = new ArrayList<StringBuilder>();
            for(int j = 0; j < chars.length; j++) {
                for(StringBuilder builder:builders) {
                    StringBuilder newBuilder = new StringBuilder(builder);
                    newBuilder.append(chars[j]);
                    newBuilders.add(newBuilder);
                }
                if(builders.isEmpty()){
                    StringBuilder newBuilder = new StringBuilder();
                    newBuilder.append(chars[j]);
                    newBuilders.add(newBuilder);
                }
            }
            builders = newBuilders;
        }
        
        for(StringBuilder builder:builders) {
            result.add(builder.toString());
        }
        return result;
    }
    
}
