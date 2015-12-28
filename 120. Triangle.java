public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null)    return 0;
        
        int rows = triangle.size();
        if(rows == 0)   return 0;
        if(rows == 1)   return triangle.get(0).get(0);
        
        int cols = triangle.get(rows-1).size(); // column number of the 2nd last row
        int[] min = new int[cols];
        int r = rows - 1;
        for(int c = 0; c < cols; c++) {
            min[c] = triangle.get(r).get(c);
        }
        cols--;
        
        for(r-- ; r > -1; r--) {
            for(int c = 0; c < cols; c++) {
                min[c] = Math.min(min[c], min[c+1]) + triangle.get(r).get(c);
            }
            cols--;
        }
        
        return min[0];
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 13: java.lang.ArrayIndexOutOfBoundsException: -1
Last executed input:
[[1],[2,3]]
*/
