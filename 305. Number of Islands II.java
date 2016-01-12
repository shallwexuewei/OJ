public class Solution {
    private int R;
    private int C; 
    private int[] p;
    
    public class UF {
        private int R;
        private int C;
        private int[] parent;
        private byte[] rank;
        private int count;  // the number of islands
        private int N;      // total grid number + 1
        
        public UF(int R, int C) {
            this.R = R;
            this.C = C;
            N = R*C+1;
            count = 0;
            parent = new int[N];
            rank = new byte[N]; 
        }
        
        public int index(int r, int c) {
            return r*C+c+1;
        }
        
        public int getCount() {
            return count;
        }
        

		public void add(int r, int c) {
			// validate
			int i = index(r, c);
			parent[i] = i;
			count++;
			
			// up
			if(r > 0) {
				explore(i, i - C);
			}
			// down
			if(r < R - 1) {
				explore(i, i + C);
			}
			// left
			if(c > 0) {
				explore(i, i - 1);
			}
			// right
			if(c < C - 1) {
				explore(i, i + 1);
			}
		}

		public int find(int p) {
			// validate p
			while (p != parent[p]) {
				parent[p] = parent[parent[p]]; // path compression;
				p = parent[p];
			}
			return p;
		}

		public int count() {
			return count;
		}

		public void explore(int i, int j) { 
			if (parent[j] != 0) {
				union(i, j);
			}
		}
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ)  return;
            
            // weighted
            if      (rank[rootP] < rank[rootQ])     parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ])     parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
        }
        
        
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        
        UF uf = new UF(m, n);
        for(int[] rc:positions) { 
            uf.add(rc[0], rc[1]);
            res.add(uf.count());
        }
        
        return res;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
3
3
[[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]
Output:
[1,2,3,4,2,2,1]
Expected:
[1,2,3,4,3,2,1]
*/
