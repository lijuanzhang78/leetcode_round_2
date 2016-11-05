package DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
	public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character,Set<Character>> map = new HashMap<>();
        int[] visited = new int[26];
        if(!buildGraph(words,map,visited)) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                char v = (char)(i+'a');
                if (!dfs(v,map,visited,sb)) return "";
            }
        }
        return sb.reverse().toString();
    }
    
    boolean dfs(char v, Map<Character,Set<Character>> map, int[] visited, StringBuilder sb) {
        if (map.containsKey(v)) {
            for(Character adj : map.get(v)) {
                if (visited[adj-'a'] == 1) return false;
                if (visited[adj-'a'] == 0) {
                    visited[adj-'a'] = 1;
                    if (!dfs(adj,map,visited,sb)) return false;
                }
            }
        }
        visited[v-'a'] = 2;
        sb.append(v);
        return true;
    }
    
    boolean buildGraph(String[] words, Map<Character,Set<Character>> map, int[] visited) {
        Arrays.fill(visited,-1);
        for(int i = 0; i < words.length; i++) {
            String curr = words[i];
            for(int k = 0; k < curr.length(); k++) {
                visited[curr.charAt(k)-'a'] = 0;
            }
            if (i == 0) continue;
            
            String pre = words[i-1];
            int len = Math.min(curr.length(),pre.length());
            int count = 0;
            for(int j = 0; j < len; j++) {
                if (curr.charAt(j) != pre.charAt(j)) {
                    if (!map.containsKey(pre.charAt(j))) {
                        map.put(pre.charAt(j), new HashSet<Character>());
                    }
                    map.get(pre.charAt(j)).add(curr.charAt(j));
                    break;
                } else {
                    count++;
                }
            }
            // 之前缺少这步的判断
            if (count == len && pre.length() > curr.length()) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String[] words = {"wrtkj","wrt"};
    	String res = new AlienDictionary().alienOrder(words);    	
    }
}
