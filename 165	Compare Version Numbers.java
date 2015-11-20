public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\."); 
        
        int v1, v2;
        
        if(strs1.length == 1)
            v1 = Integer.parseInt(version1);
        else                 
            v1 = Integer.parseInt(strs1[0]);
        
        if(strs2.length == 1)    
            v2 = Integer.parseInt(version2);
        else                 
            v2 = Integer.parseInt(strs2[0]);
        
        
        if(v1 > v2) return 1;
        else if(v1 < v2) return -1;
        else { 
            int m1 = 0;
            int m2 = 0;
            if(strs1.length > 1) {
                m1 = Integer.parseInt(strs1[1]);
            }
            if(strs2.length > 1) {
                m2 = Integer.parseInt(strs2[1]);
            }
            if(m1 > m2) return 1;
            else if(m1 < m2) return -1;
            else return 0;
        }
    }
}


/*
Runtime Error

Run Code Result: ×

Your input

"1"
"0"
Your answer

Line 6: java.lang.ArrayIndexOutOfBoundsException: 0
Expected answer

1

 Runtime Error More Details 

Runtime Error Message:
Line 22: java.lang.ArrayIndexOutOfBoundsException: 1
Last executed input:
"01"
"1"

Runtime Error Message:
Line 9: java.lang.NumberFormatException: For input string: "1.0"
Last executed input:
"1.0"
"1.1"

Input:
"1.0"
"1"
Output:
1
Expected:
0

Wrong Answer More Details 

Input:
"1.0.1"
"1"
Output:
0
Expected:
1
*/
