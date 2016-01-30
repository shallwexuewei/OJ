public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0)   return new LinkedList<int[]>();
        
        return getSkyline(buildings, 0, buildings.length - 1);
    }
    
    private LinkedList<int[]> getSkyline(int[][] buildings, int left, int right) {
        if(right == left) {
            LinkedList<int[]> skyline = new LinkedList<int[]>();
            skyline.add(new int[] {buildings[left][0], buildings[left][2]});
            skyline.add(new int[] {buildings[left][1], 0});
            return skyline;
        }
        
        int mid = left + (right - left)/2;
        LinkedList<int[]> skyline1 = getSkyline(buildings, left, mid);
        LinkedList<int[]> skyline2 = getSkyline(buildings, mid + 1, right);
        return merge(skyline1, skyline2);
    }
    
    private LinkedList<int[]> merge(LinkedList<int[]> skyline1, LinkedList<int[]> skyline2) {
        LinkedList<int[]> result = new LinkedList<int[]>();
        int h1 = 0; // fakeHead
        int h2 = 0;
        while(!skyline1.isEmpty() && !skyline2.isEmpty()){
            int x1 = skyline1.getFirst()[0];
            int x2 = skyline2.getFirst()[0];
            int x = 0;
            int h = 0;
            if(x1 < x2) {
                h1 = skyline1.getFirst()[1];
                h = Math.max(h1, h2);
                x = x1;
                skyline1.removeFirst();
            } else if(x1 > x2) {
                h2 = skyline2.getFirst()[1];
                h = Math.max(h1, h2);
                x = x2;
                skyline2.removeFirst();
            } else {
                h1 = skyline1.getFirst()[1];
                h2 = skyline2.getFirst()[1];
                h = Math.max(h1, h2);
                x = x1;
                skyline1.removeFirst();
                skyline2.removeFirst();
            }
            if(result.isEmpty() || h != result.getLast()[1]){
                result.add(new int[] {x, h});
            }
        }
        result.addAll(skyline1);
        result.addAll(skyline2);
        return result;
    }
    
    
}
