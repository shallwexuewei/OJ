public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null)    return -1;
        
        int len = nums.length;
        if(len == 0)        return -1;
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i = 0; i < k && i < len; i++) {
            q.add(nums[i]);
        }
        
        for(int i = k; i < len; i++) {
            q.add(nums[i]);
            q.poll();
        } 
        
        return q.poll();
    }
}


Solution 2:
import java.util.Random;

public class Solution {
   private void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private void shuffle(int a[]) {

        Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    
    private int partition(int[] a, int lo, int hi) { 
        
        int i = lo; 
        int j = hi + 1;
        int sentinel = a[lo];
        
        
        while(true) {
            while(a[++i] < sentinel) {
                if(i == hi) break;
            }
            
            while(a[--j] > sentinel) {
                if(j == lo) break;
            }
            /*
            i++;
            while(i < hi && a[i] < sentinel) {
                i++;
            }
            
            j--;
            while(a[j] > sentinel) {
                j--;
            }
            */
            
            
            if(i >= j)  break;
            exch(a, i, j);
        }
        
        exch(a, lo, j);
        return j;
    }
    
    public int findKthLargest(int[] nums, int k) {
        if(nums == null)    return -1;
        
        int len = nums.length;
        if(len == 0)        return -1;
        
        int targetIndex = len - k;
        int lo = 0;
        int hi = len-1;
        
        shuffle(nums);
        while(hi > lo) {
            int j = partition(nums, lo, hi);
            if(j < targetIndex) {
                lo = j + 1;
            } else if(j > targetIndex) {
                hi = j - 1;
            } else {
                return nums[j];
            }
        }
        
        return nums[lo];
    }
}

/*
Run Code Status: Runtime Error

Run Code Result: 

Your input

[1]
1
Your answer

Line 3: java.lang.ArrayIndexOutOfBoundsException: 1
Expected answer

1

Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 3: java.lang.ArrayIndexOutOfBoundsException: 2
Last executed input:
[2,1]
1
*/
