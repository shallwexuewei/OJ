public class Solution {

    public int minCostII(int[][] costs) {
        if(costs == null) return 0;
        
        int numHouse = costs.length;
        if(numHouse == 0) return 0;
        
        int numColor = costs[0].length;
        int[][] memos = new int[numHouse][];
        for(int i = 0; i < numHouse; i++) {
            memos[i] = new int[numColor];
        }  
        
        return minCost(costs, 0, -1, memos, numHouse, numColor);
    }
    
    private int minCost(int[][] costs, int iHouse, int prevColor, int[][] memos, int numHouse, int numColor) { 
        if(iHouse == numHouse) {
            return 0;
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int c = 0; c < numColor; c++) {
            if(c != prevColor) { 
                if(memos[iHouse][c] == 0) {  
                    memos[iHouse][c] = costs[iHouse][c] + minCost(costs, iHouse + 1, c, memos, numHouse, numColor);
                } 
            	minCost = Math.min(minCost, memos[iHouse][c]);
            }
        } 
        return minCost;
    }
}
