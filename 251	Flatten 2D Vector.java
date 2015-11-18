public class Vector2D {
    int r;
    int c;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        r = 0;
        c = 0;
        this.vec2d = vec2d;
    }

    public int next() {
        int temp = vec2d.get(r).get(c);
        c++;
        return temp;
    }

    public boolean hasNext() {   
        while(r < vec2d.size() && (vec2d.get(r).isEmpty() || vec2d.get(r).size() == c)){
            r++;
            c = 0;
        }
        if(r == vec2d.size()){
            return false;
        } else {
            if(c < vec2d.get(r).size()){
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
