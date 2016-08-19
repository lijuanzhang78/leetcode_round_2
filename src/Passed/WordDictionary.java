package Passed;

public class WordDictionary {
	TrieNode root = new TrieNode();
    public class TrieNode {
        TrieNode[] children;
        boolean isleaf;
        
        public TrieNode() {
            children = new TrieNode[26];
            isleaf = false;
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ws.children[ch-'a'] == null) {
                TrieNode node = new TrieNode();
                ws.children[ch-'a'] = node;
            }
            ws = ws.children[ch-'a'];
        }
        ws.isleaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(TrieNode root, String word) {
//        if (word.length() == 0) return true;
        TrieNode ws = root;
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch != '.') {
                if (ws.children[ch-'a'] == null) return false;
                ws = ws.children[ch-'a'];
            } else {
                for(int j = 0; j < 26; j++) {
                    if (ws.children[j] != null) {
                        if(i+1<word.length()) {
                            if(search(ws.children[j], word.substring(i+1))) return true;
                        } else {
                            if(ws.children[j].isleaf) return true;
                        }
                    }
                }
                return false;
            }
        }
        
        return ws.isleaf;
    }
    
    public boolean search(String word) {
        return search(root, word);
    }
}
