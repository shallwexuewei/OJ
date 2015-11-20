public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) {
            return false;
        }
        
        int cols = matrix[0].length;
        if(cols == 0) {
            return false;
        }
        
        int size = rows * cols;
        
        int low = 0;
        int high = size - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int val = get(matrix, mid, cols);
            if(target < val){
                high = mid - 1;
            } else if(target > val) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    
    private int get(int[][] m, int i, int cols) {
        int[] rc = index2rc(i, cols);
        return m[rc[0]][rc[1]];
    }
    
    private int[] index2rc(int i, int cols){
        int[] rc = new int[2];
        rc[0] = i/cols;
        rc[1] = i%cols;
        return rc;
    }
}
