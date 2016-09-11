package Passed;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        //buildAdj(wordList,map);
       
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        wordList.remove(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                String curr = queue.poll();
                for(int j = 0; j < curr.length(); j++) {
                    char[] arr = curr.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        if (!arr.equals(curr) && wordList.contains(new String(arr))) {
                            String now = new String(arr);
                            if (now.equals(endWord)) return level;
                            queue.add(now);
                            wordList.remove(now);
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    void buildAdj(Set<String> wordList, Map<String, List<String>> map) {
        for(String word : wordList) {
            List<String> adjList = new ArrayList<String>();
            getAdjForWord(word, adjList, wordList);
            map.put(word,adjList);
        }
    }
    
    void getAdjForWord(String word, List<String> adjList, Set<String> wordList) {
        for(String w : wordList) {
            if (w.equals(word)) continue;
            int count = 0;
            for(int i = 0; i < w.length(); i++) {
                if (w.charAt(i) != word.charAt(i)) count++;                
            }
            if (count == 1) adjList.add(w);
        }
    }
}
