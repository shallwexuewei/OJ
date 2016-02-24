public class Solution {
    private final int CHARACTER_SIZE = 256;
    public List<String> generatePalindromes(String s) {
        int[] nums = new int[CHARACTER_SIZE];
        int oddNum = 0;
        for(int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)]++;
            if(nums[s.charAt(i)] % 2 == 0) {
                oddNum--;
            } else {
                oddNum++;
            }
        }
        
        List<String> result = new ArrayList<>();
        if(oddNum > 1) {
            return result;
        }
        String cur = "";
        if(oddNum == 1) {
            for(int i = 0; i < CHARACTER_SIZE; i++) {
                if(nums[i]%2 == 1) {
                    cur += (char)i;
                    nums[i]--;
                    break;
                }
            }
        }
        
        dfs(nums, result, cur);
        return result;
    }
    
    private void dfs(int[] nums, List<String> result, String cur) {
        
        boolean isEmpty = true;
        for(int i = 0; i < CHARACTER_SIZE; i++) {
            if(nums[i] > 0) {
                nums[i] -= 2;
                char ch = (char)i;
                dfs(nums, result, ch+cur+ch);
                nums[i] += 2;
                if(isEmpty) {
                    isEmpty = false;
                }
            }
        }
        if(isEmpty) {
            result.add(cur);
        }
    }
}
