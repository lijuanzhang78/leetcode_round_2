package Passed;

public class ShortestWordDistanceII {
	 Map<String, List<Integer>> map;
	    public WordDistance(String[] words) {
	        map = new HashMap<>();
	        for(int i = 0; i < words.length; i++) {
	            String s = words[i];
	            if(!map.containsKey(s)) {
	                List<Integer> list = new ArrayList<>();
	                map.put(s, list); 
	            }
	            map.get(s).add(i);
	        }
	    }

	    public int shortest(String word1, String word2) {
	        int res = Integer.MAX_VALUE;
	        List<Integer> list1 = map.get(word1);
	        List<Integer> list2 = map.get(word2);
	        for(int i1 : list1) {
	            for(int i2: list2) {
	                int max = Math.max(i1, i2);
	                int min = Math.min(i1, i2);
	                int dis = max - min;
	                res = Math.min(res, dis);
	            }
	        }
	        return res;
	    }
}
