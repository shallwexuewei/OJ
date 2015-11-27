public class Solution {
    public class Point{
        public int r;
        public int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
  public int numIslands(char[][] grid) {
      // DFS, but use queue, 
      // if 1 add to the head, or add to the tail
      // when the head is 0, we know that one island has been traversed
      // Time: O(N), N: size of grid
      
      if(grid == null) {
          throw new IllegalArgumentException();
      }
      
      int rows = grid.length;
      if(rows == 0) {
          return 0;
      }
      
      int cols = grid[0].length;
      if(cols == 0) {
          return 0;
      }
      
      int r = 0;
      int c = 0;
      // find the first 1
      for( r = 0; r < rows; r++) {
          for( c = 0; c < cols; c++) { 
              if(grid[r][c] == '1') {
                  grid[r][c] = 'i';
                  break;
              }  
              grid[r][c] = 'w';
          }
          if(c != cols) {
          	break;
          }
      }

      if(r == rows) {
          return 0;
      }
      
      LinkedList<Point> q = new LinkedList<Point>();
      q.add(new Point(r, c));
      int cnt = 0;
      boolean prev1 = false;
      while(!q.isEmpty()){
          Point p = q.removeFirst();
          r = p.r;
          c = p.c; 
          if(grid[r][c] == 'w' && prev1 == true) {
              prev1 = false;
          } else if(grid[r][c] == 'i' && prev1 == false) {
              prev1 = true;
              cnt++;
          }
          // up
          if(r > 0) {
              if(enqueue(grid, q, r - 1, c)  && !prev1){
            	  continue;
              }
          }
          // down
          if(r < rows - 1) {
        	  if(enqueue(grid, q, r + 1, c)  && !prev1){
            	  continue;
              }
          }
          // left
          if(c > 0) {
        	  if(enqueue(grid, q, r, c - 1)  && !prev1){
            	  continue;
              }
          }
          // right
          if(c < cols - 1) {
        	  if(enqueue(grid, q, r, c + 1)  && !prev1){
            	  continue;
              }
          }
      }
      
       
      return cnt;
  }
  
  private boolean enqueue(char[][] grid, LinkedList<Point> q, int r, int c) {
      if(grid[r][c] == '0') {
          grid[r][c] = 'w';
          q.addLast(new Point(r, c));
      } else if(grid[r][c] == '1')  {
          grid[r][c] = 'i';
          q.addFirst(new Point(r, c));
          return true;
      }
      return false;
  }
    
}

/*
Wrong Answer More Details 

Input:
["1"]
Output:
0
Expected:
1



 Runtime Error More Details 

Runtime Error Message:
Line 89: java.lang.ArrayIndexOutOfBoundsException: 1
Last executed input:
["1","1"]



 Wrong Answer More Details 

Input:
["1011011"]
Output:
1
Expected:
3


Wrong Answer More Details 

Input:
["010","101","010"]
Output:
2
Expected:
4

Wrong Answer More Details 

Input:
["111","010","010"]
Output:
2
Expected:
1
*/
