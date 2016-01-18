public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int down = x;
        int up = x;
        int left = y;
        int right = y;
        
        LinkedList<Integer[]> list = new LinkedList<Integer[]>();
        Integer[] xy = new Integer[2];
        xy[0] = x;
        xy[1] = y;
        list.add(xy);
        
        int height = image.length;
        int width = image[0].length;
        while(!list.isEmpty()){
            xy = list.removeFirst();
            x = xy[0];
            y = xy[1];
            // up
            if(x > 0 && image[x-1][y] == '1'){
                addQueue(list, x - 1, y, image);
                if(x - 1 < up) {
                    up = x - 1;
                }
            }
            // down
            if(x < height - 1 && image[x+1][y] == '1') {
                addQueue(list, x + 1, y, image);
                if(x + 1 > down) {
                    down = x + 1;
                }
            }
            // left
            if(y > 0 && image[x][y-1] == '1') { 
                addQueue(list, x, y-1, image); 
                if(y - 1 < left) {
                    left = y - 1;
                }
            }
            // right
            if(y < width - 1 && image[x][y+1] == '1') { 
                addQueue(list, x, y + 1, image);  
                if(y + 1 > right) {
                    right = y + 1;
                }
            }
        }
        return (right - left + 1)*(down - up + 1);
    }
    
    private void addQueue(LinkedList<Integer[]> q, int x, int y, char[][] image) {
        Integer[] xy = new Integer[2];
        xy[0] = x;
        xy[1] = y;
        q.add(xy);
        image[xy[0]][xy[1]] = '0';
    }
}
