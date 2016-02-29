public class Solution {
    public String reverseWords(String s) {
        if(s == null)   return s;
        
        s = s.trim();
        if(s.length() == 0) return s;
        
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = strs.length - 1; i > -1; i--) {
            if(strs[i].isEmpty()) {
                continue;
            }
            builder.append(strs[i]);
            builder.append(' ');
        }
        builder.setLength(builder.length() - 1);
        
        return builder.toString();
    }
}
