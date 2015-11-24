/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
         
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
         
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }
         
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
         
        return -1;
    }
}

/*
 Time Limit Exceeded More Details 

Last executed input:
0 knows 1
0 knows 2
0 does not know 3
0 knows 4
0 knows 5
0 knows 6
0 does not know 7
0 does not know 8
0 knows 9
0 does not know 10
0 knows 11
0 knows 12
0 knows 13; 1 knows 0
1 knows 2
1 does not know 3
1 knows 4
1 does not know 5
1 does not know 6
1 does not know 7
1 does not know 8
1 knows 9
1 knows 10
1 knows 11
1 does not know 12
1 does not know 13; 2 knows 0
2 knows 1
2 does not know 3
2 knows 4
2 does not know 5
2 does not know 6
2 does not know 7
2 does not know 8
2 knows 9
2 does not know 10
2 knows 11
2 does not know 12
2 does not know 13; 3 does not know 0
3 does not know 1
3 knows 2
3 knows 4
3 does not know 5
3 knows 6
3 does not know 7
3 knows 8
3 knows 9
3 does not know 10
3 knows 11
3 knows 12
3 knows 13; 4 knows 0
4 does not know 1
4 knows 2
4 does not know 3
4 knows 5
4 does not know 6
4 knows 7
4 knows 8
4 knows 9
4 does not know 10
4 knows 11
4 knows 12
4 does not know 13; 5 knows 0
5 does not know 1
5 does not know 2
5 does not know 3
5 does not know 4
5 knows 6
5 knows 7
5 does not know 8
5 knows 9
5 knows 10
5 knows 11
5 does not know 12
5 does not know 13; 6 does not know 0
6 does not know 1
6 does not know 2
6 knows 3
6 knows 4
6 does not know 5
6 knows 7
6 does not know 8
6 knows 9
6 knows 10
6 knows 11
6 does not know 12
6 knows 13; 7 knows 0
7 knows 1
7 knows 2
7 does not know 3
7 knows 4
7 does not know 5
7 knows 6
7 knows 8
7 knows 9
7 does not know 10
7 knows 11
7 does not know 12
7 knows 13; 8 knows 0
8 knows 1
8 knows 2
8 does not know 3
8 knows 4
8 does not know 5
8 knows 6
8 knows 7
8 knows 9
8 knows 10
8 knows 11
8 does not know 12
8 does not know 13; 9 does not know 0
9 knows 1
9 knows 2
9 knows 3
9 knows 4
9 knows 5
9 does not know 6
9 does not know 7
9 knows 8
9 knows 10
9 knows 11
9 does not know 12
9 does not know 13; 10 knows 0
10 does not know 1
10 does not know 2
10 knows 3
10 does not know 4
10 does not know 5
10 knows 6
10 knows 7
10 does not know 8
10 knows 9
10 knows 11
10 does not know 12
10 does not know 13; 11 does not know 0
11 does not know 1
11 does not know 2
11 does not know 3
11 does not know 4
11 does not know 5
11 does not know 6
11 does not know 7
11 does not know 8
11 does not know 9
11 does not know 10
11 does not know 12
11 does not know 13; 12 does not know 0
12 knows 1
12 does not know 2
12 does not know 3
12 knows 4
12 knows 5
12 knows 6
12 knows 7
12 does not know 8
12 does not know 9
12 does not know 10
12 knows 11
12 does not know 13; 13 does not know 0
13 does not know 1
13 knows 2
13 knows 3
13 does not know 4
13 knows 5
13 does not know 6
13 knows 7
13 knows 8
13 knows 9
13 knows 10
13 knows 11
13 does not know 12.
*/
