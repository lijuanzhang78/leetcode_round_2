package DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityII {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        
        Map<String,Set<String>> adjList = new HashMap<>();
        for(String[] p : pairs) {
            if (!adjList.containsKey(p[0])) {
                adjList.put(p[0], new HashSet<String>());
            }
            adjList.get(p[0]).add(p[1]);
            
            if (!adjList.containsKey(p[1])) {
                adjList.put(p[1], new HashSet<String>());
            }
            adjList.get(p[1]).add(p[0]);    
        }
        
        for(int i = 0; i < words1.length; i++) {
            if (!dfs(words1[i],words2[i],adjList, new HashSet<String>())) return false;
        }
        return true;
    }
    
    boolean dfs(String source, String dest, Map<String,Set<String>> adjList, Set<String> visited) {
        visited.add(source);
        if (source.equals(dest)) return true;
        if (!adjList.containsKey(source)) return false;
        for(String adj : adjList.get(source)) {
            if (adj.equals(dest)) return true;
            if (!visited.contains(adj)) {
                visited.add(adj);
                if (dfs(adj,dest,adjList,visited)) return true;
            }
        }
        return false;        
    }
}
