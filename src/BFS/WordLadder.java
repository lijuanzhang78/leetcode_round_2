package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) return 0;
        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        wordList.add(endWord);
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                for(int j = 0; j < curr.length(); j++) {
                    char[] arr = curr.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == arr[j]) continue;
                        arr[j] = ch;
                        String newStr = new String(arr);
                        if (newStr.equals(endWord)) return level;
                        if (wordList.contains(newStr) && !visited.contains(newStr)) {
                            q.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		String beginWord = "hot";
		String endWord = "dog";
		Set<String> wordList = new HashSet<>();
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("dot");
		
		int res = new WordLadder().ladderLength(beginWord, endWord, wordList);		
	}
}
