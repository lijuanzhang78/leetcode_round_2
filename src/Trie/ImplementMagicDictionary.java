package Trie;

public class ImplementMagicDictionary {
	class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();    
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict) {
            TrieNode curr = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];                
            }
            curr.isWord = true;
        }   
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char orig = arr[i];
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == arr[i]) {
                    continue;
                } else {
                    arr[i] = ch;          
                }
                if (helper(arr,root)) {
                    return true;
                } else {
                    arr[i] = orig;   
                }
            }
        }
        return false;        
    }
    
    boolean helper(char[] arr, TrieNode root) {
        TrieNode curr = root;
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (curr.children[c-'a'] == null) {
                return false;                
            } else {
                curr = curr.children[c-'a'];
            }            
        }
        return curr.isWord;       
    }

}
