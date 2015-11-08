public class Solution { 
    
    public int minCost(int[][] costs) {
        if(costs == null) {
            return 0;
        }
        
        // depth first search 
        int last = costs.length - 1;
        
        if(last < 0) {
            return 0;
        } 
         
        int[][] memo = new int[costs.length][costs[0].length];
         
        return minCost(costs, -1, 0, last, memo);
    }
    
    public int minCost(int[][] costs, int prevColor, int current, int last, int[][] memo) {
        if(prevColor != -1 && memo[current][prevColor] != 0){
            return memo[current][prevColor];
        }
        
        // base case
        if(current == last) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < costs[last].length; i++) {
                if(i == prevColor) {
                    continue;
                }
                min = Math.min(min, costs[last][i]);
            }
            return min;
        } 
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < costs[current].length; i++) {
            if(i == prevColor) {
                continue;
            }
            min = Math.min(min, costs[current][i] + minCost(costs, i, current + 1, last, memo));
        } 
        if(prevColor != -1)
            memo[current][prevColor] = min;
        return min;
    }
}
