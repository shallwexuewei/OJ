public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int height = image.length;
        int width = image[0].length;
        
        int r = x;
        int c = y;
        int up = 0;
        while(up < r) {
            int mid = up + (r - up)/2;
            if(checkRow(image, mid, 0, width-1)){
                r = mid;
            } else {
                up = mid + 1;
            }
        }
        up = r;
        
        r = x;
        int down = height - 1;
        while(down > r) {
            int mid = r + (down - r + 1)/2;
            if(checkRow(image, mid, 0, width - 1)) {
                r = mid;
            } else {
                down = mid - 1;
            }
        }
        down = r;
        
        int left = 0;
        while(left < c) {
            int mid = left + (c - left)/2;
            if(checkCol(image, mid, up, down)) {
                c = mid;
            } else {
                left = mid + 1;
            }
        }
        left = c;
        
        c = y;
        int right = width - 1;
        while(right > c) {
            int mid = c + (right - c + 1)/2;
            if(checkCol(image, mid, up, down)) {
                c = mid;
            } else {
                right = mid - 1;
            }
        }
        right = c;
        
        return (right - left + 1) * (down - up + 1);
    }
    
    private boolean checkRow(char[][] image, int r, int st, int end) {
        for(int c = st; c <= end; c++) {
            if(image[r][c] == '1') {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkCol(char[][] image, int c, int st, int end) {
        for(int r = st; r <= end; r++) {
            if(image[r][c] == '1') {
                return true;
            }
        }
        return false;
    }
}
