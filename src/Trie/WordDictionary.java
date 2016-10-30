package Trie;

public class WordDictionary {
	public class WordDictionary {
	    class TrieNode {
	        boolean isWord;
	        TrieNode[] children;
	        
	        public TrieNode(){
	            isWord = false;
	            children = new TrieNode[26];
	        }
	    }
	    
	    TrieNode root = new TrieNode();
	    // Adds a word into the data structure.
	    public void addWord(String word) {
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

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return search(word, 0, root);
	    }
	    
	    private boolean search(String word, int pos, TrieNode curr) {
	        if (pos == word.length()) {
	            return curr.isWord;
	        }
	        
	        char ch = word.charAt(pos);
	        if (ch == '.') {
	            for(int i = 0; i < 26; i++) {
	                if (curr.children[i] != null) {
	                    if (search(word,pos+1,curr.children[i])) return true;
	                }
	            }
	            return false;
	        } else {
	            if (curr.children[ch-'a'] != null) {
	                return search(word,pos+1,curr.children[ch-'a']);
	            } else {
	                return false;
	            }
	        }
	    }
	}
}
