public class Solution {
    
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int len = gas.length;
        int[] diff = new int[len];
        int rest = 0;
        for(int i = 0; i < len; i++) {
            diff[i] = gas[i] - cost[i];
            rest += diff[i];
        }
        
        if(rest < 0) {
            return -1;
        }
        
        int i = 0;
        while(i < len && diff[i] < 0 ) {
            i++;
        }
        if(i >= len) {
            return -1;
        }
        
        int start = i;
        int tank = 0;
        for(; i < len; i++) {
            tank += diff[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}

/*
Submission Result: Time Limit Exceeded More Details 

Last executed input:
[2,3,1]
[3,1,2]

Submission Result: Wrong Answer More Details 

Input:
[2,4]
[3,4]
Output:
1
Expected:
-1

 Wrong Answer More Details 

Input:
[6,1,4,3,5]
[3,8,2,4,2]
Output:
-1
Expected:
2

Submission Result: Wrong Answer More Details 

Input:
[1,2,3,3]
[2,1,5,1]
Output:
2
Expected:
3
*/
