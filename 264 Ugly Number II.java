import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int nthUglyNumber(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        ArrayList<Integer> uglyList2 = new ArrayList<Integer>();
        ArrayList<Integer> uglyList3 = new ArrayList<Integer>();
        ArrayList<Integer> uglyList5 = new ArrayList<Integer>(); 
        uglyList2.add(2);
        uglyList3.add(3);
        uglyList5.add(5);
        int cnt = 1;
        int min = 0;
        while(cnt < n) {
            int c2 = uglyList2.get(i2);
            int c3 = uglyList3.get(i3);
            int c5 = uglyList5.get(i5);
            min = c2;
            if(c2 < c3) {
                if(c2 < c5) {
                    i2++; 
                } else{
                    i5++;
                    min = c5;
                }
            } else {
                // c2 > c3
                if(c3 < c5) {
                    i3++;
                    min = c3;
                } else{
                    i5++;
                    min = c5;
                }
            }
            uglyList2.add(min*2);
            uglyList3.add(min*3);
            uglyList5.add(min*5); 
            cnt++;
            System.out.println(min);
            System.out.println(Arrays.toString(uglyList2.toArray()));
            System.out.println(Arrays.toString(uglyList3.toArray()));
            System.out.println(Arrays.toString(uglyList5.toArray()));
            System.out.println();
        }
        return Math.min(Math.min(uglyList2.get(i2), uglyList3.get(i3)), uglyList5.get(i5));
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.nthUglyNumber(10));
	}
}
