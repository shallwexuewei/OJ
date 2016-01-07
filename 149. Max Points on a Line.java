/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */
public class Solution {

	/*
	 * (y1-y2)/(x1-x2) = k
	 */
	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;

		int len = points.length;
		if (len < 3)
			return len;

		int max = 0;
		for (int i = 0; i < len; i++) {

			HashMap<Integer, HashMap<Integer, Integer>> x2y2cnt = new HashMap<Integer, HashMap<Integer, Integer>>();
			int overlap = 0;
			int xi = points[i].x;
			int yi = points[i].y;

			for (int j = i + 1; j < len; j++) {
				int xj = points[j].x;
				int yj = points[j].y;
				
				if(xj == xi && yj == yi) {
				    overlap++;
				    continue;
				}

				int kx = xi - xj;
				int ky = yi - yj;
				int gcd = gcd(kx, ky);
				
				if(gcd != 0) {
				    kx /= gcd;
				    ky /= gcd;
				}


				if (x2y2cnt.containsKey(kx)) {
					HashMap<Integer, Integer> y2cnt = x2y2cnt.get(kx);
					if (y2cnt.containsKey(ky)) {
						y2cnt.put(ky, y2cnt.get(ky) + 1);
					} else {
						y2cnt.put(ky, 2);
					}
				} else {
					HashMap<Integer, Integer> y2cnt = new HashMap<Integer, Integer>();
					y2cnt.put(ky, 2);
					x2y2cnt.put(kx, y2cnt);
				}
			}


			for(int kx:x2y2cnt.keySet()) {
				HashMap<Integer, Integer> y2cnt = x2y2cnt.get(kx);
				for(int ky:y2cnt.keySet()) {
					if(max < y2cnt.get(ky) + overlap) {
						max = y2cnt.get(ky) + overlap;
					}
				}
			}
			
			if(max < overlap + 1) {
			    max = overlap + 1;
			}

		}
		return max;
	}

	private int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 34: java.lang.ArithmeticException: / by zero
Last executed input:
[[0,0],[0,0]]

Submission Result: Wrong Answer More Details 

Input:
[[0,0]]
Output:
0
Expected:
1

Submission Result: Wrong Answer More Details 

Input:
[[0,0],[0,0]]
Output:
1
Expected:
2

Submission Result: Wrong Answer More Details 

Input:
[[0,0],[1,0]]
Output:
1
Expected:
2

Submission Result: Wrong Answer More Details 

Input:
[[0,0],[-1,-1],[2,2]]
Output:
2
Expected:
3

Submission Result: Wrong Answer More Details 

Input:
[[1,1],[1,1],[2,2],[2,2]]
Output:
5
Expected:
4
*/
