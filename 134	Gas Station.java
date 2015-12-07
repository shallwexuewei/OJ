public class Solution {
    
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int len = gas.length;
        int[] diff = new int[len];
        for(int i = 0; i < len; i++) {
            diff[i] = gas[i] - cost[i];
        }
        
        int i = 0;
        while(i < len && diff[i] < 0 ) {
            i++;
        }
        if(i >= len) {
            return -1;
        }
        
        int start = i;
        int tank = diff[i];
        int maxSt = i;
        int maxTank = diff[i];
        boolean prev = true;
        
        int tank0 = 0;
        if(i == 0) {
            tank0 = diff[0];
        }
        i++;
        while(i < len) {
            if(diff[i] > 0) {
                if(prev) {
                    tank += diff[i];
                    if(start == 0) {
                        tank0 = tank;
                    }
                } else {
                    start = i;
                    tank = diff[i];
                    prev = true;
                }
            }
            else {
                if(prev) {
                    if(tank > maxTank) {
                        maxTank = tank;
                        maxSt = start;
                    }
                    prev = false;
                }
            }
            i++;
        }
        
        if(prev) {
            tank += tank0;
            if(tank > maxTank) {
                maxTank = tank;
                maxSt = start;
            }
        }
        
        i = maxSt + 1;
        i = i % len;
        tank = diff[maxSt]; 
        while(i != maxSt) {
            tank += diff[i];
            if(tank < 0) {
                return -1;
            }
            
            i++;
            if(i == len) {
                i = 0;
            }
        }
        return maxSt;
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


*/
