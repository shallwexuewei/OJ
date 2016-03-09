public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            // throw
        }
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        if(len1 == 0)   return len2;
        if(len2 == 0)   return len1;
        
        /*
        int[][] dist = new int[len2+1][len1+1];
        
        for(int r = 0; r <= len2; r++) {
            dist[r][0] = r;
        }
        for(int c = 0; c <= len1; c++) {
            dist[0][c] = c;
        }
        
        for(int r = 1; r <= len2; r++) {
            for(int c = 1; c <= len1; c++) {
                dist[r][c] = Math.min(dist[r-1][c], dist[r][c-1]) + 1; // compare insertion and deletion
                if(word1.charAt(c - 1) == word2.charAt(r - 1)) {
                    if(dist[r-1][c-1] < dist[r][c]) {
                        dist[r][c] = dist[r-1][c-1];
                    }
                } else {
                    if(dist[r-1][c-1] + 1 < dist[r][c]) {
                        dist[r][c] = dist[r-1][c-1] + 1;
                    }
                }
            }
        }
        return dist[len2][len1];
        */
        
        
        int[] dist = new int[len1+1];
        
        
        for(int c = 0; c <= len1; c++) {
            dist[c] = c;
        }
        
        for(int r = 1; r <= len2; r++) {
            int prevRowCol = dist[0];
            dist[0]++;
            for(int c = 1; c <= len1; c++) {
                int temp = dist[c];
                
                // compare insertion and deletion
                if(dist[c] > dist[c-1]) {
                    dist[c] = dist[c-1] + 1;
                } else {
                    dist[c]++;
                }
                
                if(word1.charAt(c - 1) == word2.charAt(r - 1)) {
                    if(prevRowCol < dist[c]) {
                        dist[c] = prevRowCol;
                    }
                } else {
                    if(prevRowCol + 1 < dist[c]) {
                        dist[c] = prevRowCol + 1;
                    }
                }
                prevRowCol = temp;
            }
        }
        return dist[len1];
    }
}
