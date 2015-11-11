public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(Math.abs(lenS - lenT) > 1){
            return false;
        }
        
        if(lenS == lenT) { 
            boolean distOne = false;
            for(int i = 0; i < lenS; i++) {
                if(s.charAt(i) != t.charAt(i)){ 
                    if(distOne) {
                        return false;
                    } else{
                        distOne = true;
                    }
                }
            }
            return distOne;
        } else{
            if(lenS > lenT) {
                String temp = s;
                s = t;
                t = temp;
                // remember to change length values!!!
                int l = lenS;
                lenS = lenT;
                lenT = l;
            }
            // now s is shorter
            int i = 0;
            int j = 0;
            boolean distOne = false;
            while(i < lenS && j < lenT) {
                if(s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                } else if(!distOne) {
                    j++;
                    distOne = true;
                } else{
                    return false;
                }
            }
            // corner case!!! e.g. s = "a", t = ""
            if(j == i) {
                return true;
            }
            return distOne;
        }
    }
}
/*
test case
"cab"
"ad"
*/
