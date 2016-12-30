package HashTable.String;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if (!map.containsKey(c)) map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(q.size() > 0) {
            Map.Entry<Character,Integer> entry = q.poll();
            char c = entry.getKey();
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
