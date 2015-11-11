public class Solution {
    public int nthUglyNumber(int n) {
        if(n < 1) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        ArrayList<Integer> uglyList2 = new ArrayList<Integer>();
        ArrayList<Integer> uglyList3 = new ArrayList<Integer>();
        ArrayList<Integer> uglyList5 = new ArrayList<Integer>(); 
        uglyList2.add(2);
        uglyList3.add(3);
        uglyList5.add(5);
        int cnt = 2;
        int min = 0;
        while(cnt < n) {
            int c2 = uglyList2.get(i2);
            int c3 = uglyList3.get(i3);
            int c5 = uglyList5.get(i5);
            min = Math.min(Math.min(c2, c3), c5);
            if(min == c2) i2++;
            if(min == c3) i3++;
            if(min == c5) i5++;
            uglyList2.add(min*2);
            uglyList3.add(min*3);
            uglyList5.add(min*5); 
            cnt++;
        }
        return Math.min(Math.min(uglyList2.get(i2), uglyList3.get(i3)), uglyList5.get(i5));
    }
}
