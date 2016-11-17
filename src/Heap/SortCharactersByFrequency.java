package Heap;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch,0);
            }
            map.put(ch, map.get(ch)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(q.size() > 0) {
            Map.Entry<Character, Integer> entry = q.poll();
            Character ch = entry.getKey();
            Integer num = entry.getValue();
            for(int i = 0; i < num; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
