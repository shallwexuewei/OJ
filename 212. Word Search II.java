public class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private void addWord(TrieNode root, String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int charIdx = word.charAt(i)-'a';
            if(node.children[charIdx] == null) {
                node.children[charIdx] = new TrieNode();
            }
            node = node.children[charIdx];
        }
        node.word = word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>(words.length);
        if(board == null || words == null) {
            return result;
        }
        
        int R = board.length;
        if(R == 0)  return result;
        int C = board[0].length;
        if(C == 0)  return result;
        
        int numWords = words.length;
        if(numWords == 0)    return result;
        
        TrieNode root = new TrieNode();
        for(String word:words) {
            addWord(root, word);
        }
        
        boolean[][] visited = new boolean[R][C];
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                dfs(board, root, result, visited, r, c, R, C);
            }
        }
        
        return result;
        
    }
    
    private void dfs(char[][] board, TrieNode node, List<String> result, boolean[][] visited, int r, int c, int R, int C) {
        
        int charIdx = board[r][c] - 'a';
        if(node.children[charIdx] == null) {
            return;
        }
        TrieNode child = node.children[charIdx];
        if(child.word != null) {
            result.add(child.word);
            // avoid duplicate
            child.word = null;
        }
        
        visited[r][c] = true;
        // left
        if(c > 0 && !visited[r][c-1]) {
            dfs(board, child, result, visited, r, c-1, R, C);
        }
        // right
        if(c < C - 1 && !visited[r][c+1]) {
            dfs(board, child, result, visited, r, c+1, R, C);
        }
        // up
        if(r > 0 && !visited[r-1][c]) {
            dfs(board, child, result, visited, r-1, c, R, C);
        }
        // down
        if(r < R - 1 && !visited[r+1][c]) {
            dfs(board, child, result, visited, r+1, c, R, C);
        }
        
        visited[r][c] = false;
    }
    
}
