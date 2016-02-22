public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n < k || k < 1) {
            return result;
        }
        
        dfs(result, n, k, new LinkedList<Integer>(), 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int n, int k, LinkedList<Integer> list, int cur) {
        if(list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        int last = n - k + list.size() + 1;
        for(int i = cur + 1; i <= last; i++) {
            list.add(i);
            dfs(result, n, k, list, i);
            list.removeLast();
        }
        
    }
}
