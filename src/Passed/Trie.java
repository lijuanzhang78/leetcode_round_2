package Passed;


	class TrieNode {
	    // Initialize your data structure here.
	    char ch;
	    TrieNode[] children;
	    boolean isleaf;
	    
	    public TrieNode() {
	        children = new TrieNode[26];
	        isleaf = false;
	    }
	    
	    public void setChar(char c) {
	        ch = c;
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        int len = word.length();
	        TrieNode[] children = root.children;
	        for(int i = 0; i < len; i++) {
	            if (children[word.charAt(i) - 'a'] == null) {
	                TrieNode node = new TrieNode();
	                node.setChar(word.charAt(i));
	                children[word.charAt(i) - 'a'] = node;
	            }
	            if (i == len - 1) children[word.charAt(i)-'a'].isleaf = true;
	            children = children[word.charAt(i) - 'a'].children;
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        int len = word.length();
	        TrieNode[] children = root.children;
	        boolean found = true;
	        for(int i = 0; i < len; i++) {
	            if (children[word.charAt(i) - 'a'] == null) {
	                found = false;
	                break;
	            } 
	            if (i == len-1 && !children[word.charAt(i)-'a'].isleaf) {
	                found = false;
	            }
	            children = children[word.charAt(i) - 'a'].children;
	        }
	        return found;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        int len = prefix.length();
	        TrieNode[] children = root.children;
	        boolean found = true;
	        for(int i = 0; i < len; i++) {
	            if (children[prefix.charAt(i) - 'a'] == null) {
	                found = false;
	                break;
	            } 
	            children = children[prefix.charAt(i) - 'a'].children;
	        }
	        return found;
	    }
	    
	    public static void main(String[] args) {
			Trie trie = new Trie();
			trie.insert("ab");
			boolean res = trie.search("ab");			
		}
	}
	
	


