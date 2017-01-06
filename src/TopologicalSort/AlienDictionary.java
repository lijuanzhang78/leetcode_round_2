package TopologicalSort;

public class AlienDictionary {
	public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character,List<Character>> map = new HashMap<>();
        int[] visited = new int[26];
        Arrays.fill(visited,-1);
        for(String s : words) {
            for(int i = 0; i < s.length(); i++) {
                visited[s.charAt(i)-'a'] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length - 1; i++) {
            if (!compareString(words[i],words[i+1],map,visited)) return "";
        }
        for(int i = 0; i < 26; i++) {
            if (visited[i] == 0) {
                if (!dfs(sb,(char)(i+'a'),map,visited)) return "";
            }
        }
        return sb.reverse().toString();
    }
    
    boolean dfs(StringBuilder sb, char c, Map<Character,List<Character>> map, int[] visited) {
        visited[c-'a'] = 1;
        if (map.containsKey(c)) {
            for(char adj : map.get(c)) {
                if (visited[adj-'a'] == 1) return false;
                if (visited[adj-'a'] == 0) {
                    if(!dfs(sb,adj,map,visited)) return false;
                }
            }
        }
        sb.append(c);
        visited[c-'a'] = 2;
        return true;
    }
    
    boolean compareString(String s1, String s2, Map<Character,List<Character>> map, int[] visited) {
        int count = 0;
        for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (!map.containsKey(c1)) map.put(c1, new ArrayList<Character>());
                map.get(c1).add(c2);
                break;
            } else {
                count++;
            }
        }
        if (count == Math.min(s1.length(),s2.length()) && s1.length() > s2.length()) return false;
        return true;
    }
}
