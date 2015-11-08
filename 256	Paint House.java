public class Solution {
    private int globalMin;
    
    public int minCost(int[][] costs) {
        if(costs == null) {
            return 0;
        }
        
        // depth first search
        globalMin = Integer.MAX_VALUE;
        int last = costs.length - 1;
        
        if(last < 0) {
            return 0;
        }
         
        
        return minCost(costs, 0, last, 0);
    }
    
    public int minCost(int[][] costs, int current, int last, int soFarCost) {
        // base case
        if(current == last) {
            int min = costs[last][0];
            for(int i = 1; i < costs[last].length; i++) {
                min = Math.min(min, costs[last][i]);
            }
            soFarCost += min;
            globalMin = Math.min(globalMin, soFarCost);
            return soFarCost;
        }
        
        int min = minCost(costs, current + 1, last, soFarCost + costs[current][0]);
        for(int i = 1; i < costs[current].length; i++) {
            min = Math.min(min, minCost(costs, current + 1, last, soFarCost + costs[current][i]));
        }
        return min;
    }
}
