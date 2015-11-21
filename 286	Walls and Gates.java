public class Solution {
    
    public class Grid{
        public int r;
        public int c;
        public Grid(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public boolean equals(Grid that){
            return this.r == that.r && this.c == that.c;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null) return;
        
        int rows = rooms.length;
        if(rows == 0) return;
        
        int cols = rooms[0].length;
        if(cols == 0) return;
        
        LinkedList<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>(); 
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(rooms[r][c] == 0) { 
                    ArrayList<Integer> rc = new ArrayList<Integer>(2);
                    rc.add(r);
                    rc.add(c);
                    q.add(rc);
                }
            }
        }
         
        while(!q.isEmpty()){
            ArrayList<Integer> rc = q.removeFirst();
            int r = rc.get(0);
            int c = rc.get(1);
            // up
            if(r > 0) {
                visit(r-1, c, q,  rooms, rooms[r][c]+1);
            }
            // down
            if(r < rows - 1) {
                visit(r+1, c, q,   rooms, rooms[r][c]+1);
            }
            // left
            if(c > 0) {
                visit(r, c-1, q,   rooms, rooms[r][c]+1);
            }
            // right
            if(c < cols - 1) {
                visit(r, c+1, q,   rooms, rooms[r][c]+1);
            } 
        } 
    }
     
    private void visit(int r, int c, LinkedList<ArrayList<Integer>> q, int[][] rooms, int moves) { 
        if(rooms[r][c] != 2147483647) return;
        
        rooms[r][c] = moves;
        
        ArrayList<Integer> rc = new ArrayList<Integer>(2);
        rc.add(r);
        rc.add(c);
        q.add(rc);
    }
}
