package HashTable.String;

public class SentenceSimilarity {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        Map<String,Set<String>> map = new HashMap<>();
        for(String[] p : pairs) {
            if (!map.containsKey(p[0])) {
                map.put(p[0],new HashSet<String>());
            }
            map.get(p[0]).add(p[1]);
            
            if (!map.containsKey(p[1])) {
                map.put(p[1],new HashSet<String>());
            }
            map.get(p[1]).add(p[0]);            
        }
        
        for(int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i])) return false;
            if (!map.get(words1[i]).contains(words2[i])) return false;   
        }
        return true;
    }

}
