package Trie;

//backtracking + trie
public class WordSqures {
	class TrieNode {
        boolean isWord;
        TrieNode[] children;
        List<String> samePrefix;
        public TrieNode(){
            isWord = false;
            children = new TrieNode[26];
            samePrefix = new ArrayList<String>();
        }
    }
    
    TrieNode root = new TrieNode();
    void buildTrie(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) {
                TrieNode node = new TrieNode();
                curr.children[ch-'a'] = node;
            }
            curr = curr.children[ch-'a'];
            curr.samePrefix.add(word);
        }
        curr.isWord = true;
        curr.samePrefix.add(word);
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        
        for(String word : words) {
            buildTrie(word);
        }
        
        int max = words[0].length();
        for(String word : words) {
            List<String> list = new ArrayList<>();
            list.add(word);
            helper(res,list,max);
        }
        return res;
    }
    
    public List<String> prefixWith(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) return new ArrayList<String>();
            curr = curr.children[ch-'a'];
        }
        return curr.samePrefix;
    }
    
    void helper(List<List<String>> res, List<String> list, int max) {
        if (list.size() == max) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String ss : list) {
            sb.append(ss.charAt(list.size()));
        }
        List<String> prelist = prefixWith(sb.toString());
        for(String nextStr : prelist) {
            list.add(nextStr);
            helper(res,list,max);
            list.remove(list.size()-1);
        }
    }
}
