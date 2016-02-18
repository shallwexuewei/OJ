public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, new LinkedList<Integer>(), 0, result);
        return result;
    }
    
    private void combinationSum2(int[] candidates, int target, LinkedList<Integer> list, int i, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        } else if(target < 0) {
            return;
        }
        
        for(int j = i; j < candidates.length; j++) {
            // prune
            if(candidates[j] > target) {
                break;
            }
            // prevent duplicate
            if(j > 0 && j > i && candidates[j] == candidates[j-1]) {
                continue;
            }
            
            list.add(candidates[j]);
            combinationSum2(candidates, target - candidates[j], list, j + 1, result);
            list.removeLast();
            
        }
    } 
}
