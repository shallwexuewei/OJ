public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null)    return "";
        
        // int to string
        int len = nums.length;
        if(len == 0)        return "";
        
        PriorityQueue<String> q = new PriorityQueue<String>(len, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
         
        for(int n:nums) {
            String s = "" + n;
            q.add(s);
        }
        
        // special case, 0 is only number
        if(q.peek().equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll());
        }
        return sb.toString();
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2]
Output:
"1"
Expected:
"21"

Submission Result: Wrong Answer More Details 

Input:
[128,12]
Output:
"12128"
Expected:
"12812"

Submission Result: Wrong Answer More Details 

Input:
[0,0]
Output:
"00"
Expected:
"0"
*/
