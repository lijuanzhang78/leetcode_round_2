package BFS;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return res;
        
        wordList.add(endWord);
        wordList.add(beginWord);
        Set<String> visited = new HashSet<>();
        Map<String, Integer> layers = new HashMap<String, Integer>();
        
        // 这一步建立从后往前的adj很重要
        Map<String, List<String>> adjList = new HashMap<String,List<String>>(); 
        for(String s : wordList) {
            adjList.put(s, new ArrayList<>());
        }
        
        int level = 0;
        layers.put(beginWord, 0);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        
        boolean found = false;
        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            for(int isize = 0; isize < size; isize++) {
                String curr = q.poll();
                for(int i = 0; i < curr.length(); i++) {
                    char[] arr = curr.toCharArray();
                    char old = arr[i];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if (old == ch) continue;
                        arr[i] = ch;
                        String newS = String.valueOf(arr);
                        if (wordList.contains(newS)) {
                            //adjList.get(curr).add(newS);
                            adjList.get(newS).add(curr);
                        }
                        if (newS.equals(endWord)) {
                            layers.put(endWord,level);
                            found = true;
                        }
                        if (!visited.contains(newS) && wordList.contains(newS)) {
                            q.add(newS);
                            layers.put(newS,level);
                            visited.add(newS);
                        }
                    }
                }
            }
            if (found) break;
        }
        
        buildPath(layers,new ArrayList<String>(),res, beginWord, endWord, adjList);
        return res;
    }
    
    void buildPath(Map<String, Integer> layers, List<String> path, List<List<String>> res, String beginWord, String word, Map<String, List<String>> adjList) {
        path.add(0,word);
        if (word.equals(beginWord)) {
            res.add(new ArrayList<String>(path));
            return;
        }
        
        for(String adj : adjList.get(word)) {
            if (layers.get(adj) == layers.get(word) - 1) {
                buildPath(layers,path,res,beginWord,adj,adjList);
                path.remove(0);
            }
        }
    }
}
