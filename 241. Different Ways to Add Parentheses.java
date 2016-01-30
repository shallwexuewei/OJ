public class Solution {
    
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if(input.length() == 0) return result;
        
        int len = input.length();
        return compute(input, 0, len-1);
    }
    
    private ArrayList<Integer> compute(String input, int lo, int hi) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i = lo; i <= hi; i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                ArrayList<Integer> lefts = compute(input, lo, i-1);
                ArrayList<Integer> rights = compute(input, i+1, hi);
                for(int left:lefts) {
                    for(int right:rights) {
                        if(c == '+') {
                            result.add(left + right);
                        }
                        if(c == '-') {
                            result.add(left - right);
                        }
                        if(c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        if(result.size() == 0) {
            result.add( Integer.parseInt(input.substring(lo, hi+1)));
        } 
        return result;
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 18: java.lang.StackOverflowError
Last executed input:
"0+1"
*/
