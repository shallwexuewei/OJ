public class ZigzagIterator {
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    boolean turn1;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        if(it1.hasNext())   turn1 = true;
        else                turn1 = false;
    }

    public int next() {
        if(turn1) {
            int res = it1.next();
            if(it2.hasNext()){
                turn1 = false;
            }
            return res;
        } else {
            int res = it2.next();
            if(it1.hasNext()){
                turn1 = true;
            }
            return res;
        }
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 /*
 Submission Result: Runtime Error More Details 

Last executed input:
[]
[1]
*/
