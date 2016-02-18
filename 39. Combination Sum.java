public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, 0, new LinkedList<Integer>());
        return result;
    }
    
    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, int i, LinkedList<Integer> list) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        } else if(target < 0) {
            return;
        }
        
        for(int j = i; j < candidates.length; j++) {
            // pruning
            if(candidates[j] > target) {
                break;
            }
            list.add(candidates[j]);
            combinationSum(candidates, target - candidates[j], result, j,  list);
            list.removeLast();
            
            /*
            sum += candidates[j];
            if(sum <= target) {
                list.add(candidates[j]);
                if(sum < target) {
                    combinationSum(candidates, target, result, j, sum, list);
                } else {
                    ArrayList<Integer> qualified = new ArrayList<Integer>();
                    qualified.addAll(list);
                    result.add(qualified);
                }
                list.removeLast();
            } else{
                break;
            }
            sum -= candidates[j];
            */
        }
    }
}
