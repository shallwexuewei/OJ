public class ZigzagIterator {
    int i1;
    int i2;
    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        i1 = 0;
        i2 = 0;
    }

    public int next() {
        // if i1 == i2, visit v1
        int turn = 0;  // 1: v1, 0: v2 
        if(i1 == v1.size()){
            turn = 0;
        }  
        else if(i2 == v2.size()){
            turn = 1;
        } else if(i1 == i2) {
            turn = 1;
        }
        
        if(turn == 1) {
            int r = v1.get(i1);
            i1++;
            return r;
        } else {
            int r = v2.get(i2);
            i2++;
            return r;
        }
    }

    public boolean hasNext() {
        return (i1 < v1.size() || i2 < v2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
