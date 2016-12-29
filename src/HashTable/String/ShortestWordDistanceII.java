package HashTable.String;

public class ShortestWordDistanceII {
	Map<String,List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<String,List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            if (!map.containsKey(w)) map.put(w,new ArrayList<Integer>());
            map.get(w).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(Integer idx1 : l1) {
            for(Integer idx2 : l2) {
                res = Math.min(res, Math.abs(idx1-idx2));
            }
        }
        return res;
    }
}
