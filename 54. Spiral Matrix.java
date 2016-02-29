public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(matrix == null)  return result;
        
        int R = matrix.length;
        if(R == 0)          return result;
        
        int C = matrix[0].length;
        if(C == 0)          return result;
        
        // 0:right, 1: down, 2 left, 3: up
        int direction = 0;
        int rightMax = C - 1;
        int downMax = R - 1;
        int leftMax = 0;
        int upMax = 1;
        
        int r = 0;
        int c = 0;
        while(rightMax >= leftMax && upMax <= downMax) {
            result.add(matrix[r][c]);
            if(direction == 0) {
                if(c == rightMax) {
                    direction = 1;
                    r++;
                    rightMax--;
                } else {
                    c++;
                }
            } else if(direction == 1) {
                if(r == downMax) {
                    direction = 2;
                    c--;
                    downMax--;
                } else {
                    r++;
                }
            } else if(direction == 2) {
                if(c == leftMax) {
                    direction = 3;
                    r--;
                    leftMax++;
                } else {
                    c--;
                }
            } else {
                if(r == upMax) {
                    direction = 0;
                    c++;
                    upMax++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
