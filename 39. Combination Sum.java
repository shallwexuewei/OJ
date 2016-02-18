public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, 0, 0, new LinkedList<Integer>());
        return result;
    }
    
    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, int i, int sum, LinkedList<Integer> list) {
        
        
        for(int j = i; j < candidates.length; j++) {
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
        }
    }
}
