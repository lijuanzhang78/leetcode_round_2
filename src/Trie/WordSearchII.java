package Trie;

// Trie + Backtracking
// 注意去重
// 最后一个字符不要忘记加

public class WordSearchII {
	class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    
    private void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) {
                TrieNode node = new TrieNode();
                curr.children[ch-'a'] = node;
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }
    
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) return res;
        
        for(String word : words) {
            addWord(word);
        }
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(res,"",board,root,visited,i,j);
            }
        }
        return res;
    }
    
    void helper(List<String> res, String s, char[][] board, TrieNode curr, boolean[][] visited,int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        char ch = board[i][j];
        if (curr.children[ch-'a'] == null) return;
        curr = curr.children[ch-'a'];
        visited[i][j] = true;
        if (curr.isWord) {
            res.add(s+ch); // 加上最后一个字符
            curr.isWord = false; // 去重
        }
        
        helper(res,s+ch,board,curr,visited,i+1,j);
        helper(res,s+ch,board,curr,visited,i-1,j);
        helper(res,s+ch,board,curr,visited,i,j+1);
        helper(res,s+ch,board,curr,visited,i,j-1);
        visited[i][j] = false;
    }
}
