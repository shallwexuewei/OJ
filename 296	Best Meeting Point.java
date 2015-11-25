public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException();
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        ArrayList<Integer> colList = new ArrayList<Integer>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    rowList.add(r);
                    colList.add(c);
                }
            }
        }
        
        int sum = 0;
        int midSize = rowList.size()/2;
        int mr = rowList.get(midSize);
        int mc = colList.get(midSize);
        
        for(int i = 0; i < rowList.size(); i++) {
            sum += rowList.get(i) - mr;
            sum += colList.get(i) - mc;
        }
        
        return sum;
    }
}

/*
Your input

[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Your answer

-4
Expected answer

6
*/
