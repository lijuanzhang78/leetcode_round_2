package Trie;

public class Trie_2nd {
	class TrieNode {
	    boolean isWord;
	    TrieNode[] children;
	    
	    // Initialize your data structure here.
	    public TrieNode() {
	        isWord = false;
	        children = new TrieNode[26];
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
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

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode curr = root;
	        for(int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            if (curr.children[ch-'a'] == null) return false;
	            curr = curr.children[ch-'a'];
	        }
	        return curr.isWord;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode curr = root;
	        for(int i = 0; i < prefix.length(); i++) {
	            char ch = prefix.charAt(i);
	            if (curr.children[ch-'a'] == null) return false;
	            curr = curr.children[ch-'a'];
	        }
	        return true;
	    }
	}
}
