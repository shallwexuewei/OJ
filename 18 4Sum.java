public class Solution {
    public int binarySearch(int[] nums, int a, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == a) {
                return mid;
            } else if(nums[mid] < a) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high; // < a
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            sum = nums[i];
            for(int j = i+1; j < len - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                sum += nums[j];
                
                int k = j + 1;
                sum += nums[k];
                int m = binarySearch(nums, target - sum, k + 1, len - 1);
                if(m <= k) {
                    sum -= nums[k];
                    break;
                } else if(nums[m] == target - sum) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    temp.add(nums[m]);
                    res.add(temp);
                } 
                sum -= nums[k];
                
                for( k = j+2; k < len - 1; k++) {
                    if(nums[k] == nums[k-1]) {
                        continue;
                    }
                    sum += nums[k];
                    m = binarySearch(nums, target - sum, k + 1, m);
                    if(m <= k) {
                        sum -= nums[k];
                        break;
                    }else if(nums[m] == target - sum) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[m]);
                        res.add(temp);
                    } 
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
        }
        return res;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[-3,-2,-1,0,0,1,2,3]
0
Output:
[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,1],[-2,-1,0,3],[-2,-1,0,3],[-2,-1,1,2],[-1,0,0,1]]
Expected:
[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]


 Wrong Answer More Details 

Input:
[-1,-5,-5,-3,2,5,0,4]
-7
Output:
[[-5,-5,-1,4],[-5,-3,-1,2],[-5,-3,-1,2]]
Expected:
[[-5,-5,-1,4],[-5,-3,-1,2]]
*/
