package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	Map<String, List<String>> map;
    Map<String, Integer> dist;
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0) return new ArrayList<>();
        
        dist = new HashMap<String, Integer>();
        for(String word : wordList) {
            dist.put(word, Integer.MAX_VALUE);
        }
        
        Set<String> visited = new HashSet<>();
        map = new HashMap<String, List<String>>();
        Queue<String> queue = new LinkedList<>();
        wordList.add(endWord);
        queue.add(beginWord);
        dist.put(beginWord,0);
        boolean found = false;
        
        while(!queue.isEmpty()) {
            if (found) break;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String curr = queue.poll();
                for(int j = 0; j < curr.length(); j++) {
                    char[] arr = curr.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                    
                        String newWord = new String(arr);
                        if (!newWord.equals(curr) && wordList.contains(newWord)) {
                            if(!visited.contains(newWord)) {
                                dist.put(newWord, dist.get(curr)+1);
                                List<String> list = new ArrayList<>();
                                list.add(curr);
                                map.put(newWord,list);
                                queue.add(newWord);
                                visited.add(newWord);
                            } else {
                                if (dist.get(newWord) == dist.get(curr)+1) {
                                    List<String> list = map.get(newWord);
                                    list.add(curr);
                                } else if (dist.get(curr)+1 > dist.get(newWord)) {
                                    continue;
                                }
                            }
                        
                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        outputResult(res,temp, endWord, beginWord);
        return res;
    }
    
    private void outputResult(List<List<String>> res, List<String> list, String word, String beginWord)
    {
        if (word.equals(beginWord)) {
            list.add(0,word);
            res.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        
        list.add(0,word);
        if (map.get(word)!= null) {
            for(String adj : map.get(word)) {
                outputResult(res,list,adj,beginWord);
            }
        }
        list.remove(0);
    }
	
    public static void main(String[] args) {
    	String begin = "hot";
    	String end = "dog";
    	Set<String> set = new HashSet<>();
    	    	    	
    	set.add("hot"); 
    	set.add("cog");
    	set.add("dog");
    	set.add("tot");
    	set.add("hog");
    	set.add("hop");
    	set.add("pot");
    	set.add("dot");
    	List<List<String>> res = new WordLadderII().findLadders(begin, end, set);
    }
}
