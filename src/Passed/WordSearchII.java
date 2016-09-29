package Passed;

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) return res;
        TrieNode root = buildTrie(words);
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board,res,i,j,root);
            }
        }
        return res;
    }
    
    void dfs(char[][] board, List<String> res, int i, int j, TrieNode ws) {
        char ch = board[i][j];
        if (ch == '#' || ws.children[ch-'a'] == null) return;
        ws = ws.children[ch-'a'];
        if (ws.word != null) {
            res.add(ws.word);
            ws.word = null;
        }
        
        board[i][j] = '#';
        if (i+1 < board.length) dfs(board,res,i+1,j,ws);
        if (i-1 >= 0) dfs(board,res,i-1,j,ws);
        if (j+1 < board[0].length) dfs(board,res,i,j+1,ws);
        if (j-1 >= 0) dfs(board,res,i,j-1,ws);
        board[i][j] = ch;
    }
    
    
    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ws.children[ch-'a'] == null) {
                    ws.children[ch-'a'] = new TrieNode();
                }
                ws = ws.children[ch-'a'];
            } 
            ws.word = word;
        }
        return root;
    }
    
    class TrieNode {
    // Initialize your data structure here.
        TrieNode[] children = new TrieNode[26];
        String word;
        public TrieNode() {}
    }
}
